package br.com.interfision.interfision.api.consultas.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.interfision.interfision.api.consultas.assemblers.ConsultaAssembler;
import br.com.interfision.interfision.api.consultas.dtos.ConsultaRequest;
import br.com.interfision.interfision.api.consultas.dtos.ConsultaResponse;
import br.com.interfision.interfision.api.consultas.mappers.ConsultaMapper;
import br.com.interfision.interfision.core.exceptions.ConsultaNotFoundException;
import br.com.interfision.interfision.core.repositories.ConsultaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/consultas")
public class ConsultaRestController {

    private final ConsultaMapper consultaMapper;
    private final ConsultaAssembler consultaAssembler;
    private final ConsultaRepository consultaRepository;
    private final PagedResourcesAssembler<ConsultaResponse> pagedResourcesAssembler;

    @GetMapping
    public CollectionModel<EntityModel<ConsultaResponse>> findAll(Pageable pageable) {
        var consultas = consultaRepository.findAll(pageable)
            .map(consultaMapper::toConsultaResponse);
        return pagedResourcesAssembler.toModel(consultas, consultaAssembler);
    }

    @GetMapping("/{id}")
    public EntityModel<ConsultaResponse> findById(@PathVariable Long id) {
        var consulta = consultaRepository.findById(id)
            .orElseThrow(ConsultaNotFoundException::new);
        var consultaResponse = consultaMapper.toConsultaResponse(consulta);
        return consultaAssembler.toModel(consultaResponse);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntityModel<ConsultaResponse> create(@RequestBody @Valid ConsultaRequest consultaRequest) {
        System.out.println("ConsultaRequestMessage: " + consultaRequest);
        var consulta = consultaMapper.toConsulta(consultaRequest);
        consulta = consultaRepository.save(consulta);
        var consultaResponse = consultaMapper.toConsultaResponse(consulta);
        return consultaAssembler.toModel(consultaResponse);
    }

    @PutMapping("/{id}")
    public EntityModel<ConsultaResponse> update(
        @RequestBody @Valid ConsultaRequest consultaRequest,
        @PathVariable Long id
    ) {
        var consulta = consultaRepository.findById(id)
            .orElseThrow(ConsultaNotFoundException::new);
        var consultaData = consultaMapper.toConsulta(consultaRequest);
        BeanUtils.copyProperties(consultaData, consulta, "id");
        consulta = consultaRepository.save(consulta);
        var consultaResponse = consultaMapper.toConsultaResponse(consulta);
        return consultaAssembler.toModel(consultaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var consulta = consultaRepository.findById(id)
            .orElseThrow(ConsultaNotFoundException::new);
        consultaRepository.delete(consulta);
        return ResponseEntity.noContent().build();
    }
}
