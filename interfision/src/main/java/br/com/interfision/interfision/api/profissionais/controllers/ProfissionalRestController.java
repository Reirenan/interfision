package br.com.interfision.interfision.api.profissionais.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.interfision.interfision.api.profissionais.assemblers.ProfissionalAssembler;
import br.com.interfision.interfision.api.profissionais.dtos.ProfissionalRequest;
import br.com.interfision.interfision.api.profissionais.dtos.ProfissionalResponse;
import br.com.interfision.interfision.api.profissionais.mappers.ProfissionalMapper;
import br.com.interfision.interfision.core.exceptions.ProfissionalNotFoundException;
import br.com.interfision.interfision.core.repositories.ProfissionalRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profissionais")
public class ProfissionalRestController {

    private final ProfissionalMapper profissionalMapper;
    private final ProfissionalAssembler profissionalAssembler;
    private final ProfissionalRepository profissionalRepository;
    private final PagedResourcesAssembler<ProfissionalResponse> pagedResourcesAssembler;

    @GetMapping
    public CollectionModel<EntityModel<ProfissionalResponse>> findAll(Pageable pageable) {
        var profissionais = profissionalRepository.findAll(pageable)
            .map(profissionalMapper::toProfissionalResponse);
        return pagedResourcesAssembler.toModel(profissionais, profissionalAssembler);
    }

    @GetMapping("/{id}")
    public EntityModel<ProfissionalResponse> findById(@PathVariable Long id) {
        var profissional = profissionalRepository.findById(id)
            .orElseThrow(ProfissionalNotFoundException::new);
        var profissionalResponse = profissionalMapper.toProfissionalResponse(profissional);
        return profissionalAssembler.toModel(profissionalResponse);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntityModel<ProfissionalResponse> create(@RequestBody @Valid ProfissionalRequest profissionalRequest) {
        var profissional = profissionalMapper.toProfissional(profissionalRequest);
        profissional = profissionalRepository.save(profissional);
        var profissionalResponse = profissionalMapper.toProfissionalResponse(profissional);
        return profissionalAssembler.toModel(profissionalResponse);
    }

    @PutMapping("/{id}")
    public EntityModel<ProfissionalResponse> update(
        @RequestBody @Valid ProfissionalRequest profissionalRequest, 
        @PathVariable Long id
    ) {
        var profissional = profissionalRepository.findById(id)
            .orElseThrow(ProfissionalNotFoundException::new);
        var profissionalData = profissionalMapper.toProfissional(profissionalRequest);
        BeanUtils.copyProperties(profissionalData, profissional, "id");
        profissional = profissionalRepository.save(profissional);
        var profissionalResponse = profissionalMapper.toProfissionalResponse(profissional);
        return profissionalAssembler.toModel(profissionalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var profissional = profissionalRepository.findById(id)
            .orElseThrow(ProfissionalNotFoundException::new);
        profissionalRepository.delete(profissional);
        return ResponseEntity.noContent().build();
    }
}
