package br.com.interfision.interfision.api.responsaveis.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.interfision.interfision.api.responsaveis.assemblers.ResponsavelAssembler;
import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelRequest;
import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelResponse;
import br.com.interfision.interfision.api.responsaveis.mappers.ResponsavelMapper;
import br.com.interfision.interfision.core.exceptions.ResponsavelNotFoundException;
import br.com.interfision.interfision.core.repositories.ResponsavelRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/responsaveis")
public class ResponsavelRestController {

    private final ResponsavelMapper responsavelMapper;
    private final ResponsavelAssembler responsavelAssembler;
    private final ResponsavelRepository responsavelRepository;
    private final PagedResourcesAssembler<ResponsavelResponse> pagedResourcesAssembler;

    @GetMapping
    public CollectionModel<EntityModel<ResponsavelResponse>> findAll(Pageable pageable) {
        var responsaveis = responsavelRepository.findAll(pageable)
            .map(responsavelMapper::toResponsavelResponse);
        return pagedResourcesAssembler.toModel(responsaveis, responsavelAssembler);
    }

    @GetMapping("/{id}")
    public EntityModel<ResponsavelResponse> findById(@PathVariable Long id) {
        var responsavel = responsavelRepository.findById(id)
            .orElseThrow(() -> new ResponsavelNotFoundException("Responsável com ID " + id + " não encontrado."));
        var responsavelResponse = responsavelMapper.toResponsavelResponse(responsavel);
        return responsavelAssembler.toModel(responsavelResponse);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<ResponsavelResponse> create(@RequestBody @Valid ResponsavelRequest responsavelRequest) {
        var responsavel = responsavelMapper.toResponsavel(responsavelRequest);
        responsavel = responsavelRepository.save(responsavel);
        var responsavelResponse = responsavelMapper.toResponsavelResponse(responsavel);
        return responsavelAssembler.toModel(responsavelResponse);
    }

    @PutMapping("/{id}")
    public EntityModel<ResponsavelResponse> update(
        @RequestBody @Valid ResponsavelRequest responsavelRequest,
        @PathVariable Long id
    ) {
        var responsavel = responsavelRepository.findById(id)
            .orElseThrow(() -> new ResponsavelNotFoundException("Responsável com ID " + id + " não encontrado."));
        var responsavelData = responsavelMapper.toResponsavel(responsavelRequest);
        BeanUtils.copyProperties(responsavelData, responsavel, "id");
        responsavel = responsavelRepository.save(responsavel);
        var responsavelResponse = responsavelMapper.toResponsavelResponse(responsavel);
        return responsavelAssembler.toModel(responsavelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var responsavel = responsavelRepository.findById(id)
            .orElseThrow(() -> new ResponsavelNotFoundException("Responsável com ID " + id + " não encontrado."));
        responsavelRepository.delete(responsavel);
        return ResponseEntity.noContent().build();
    }
}
