package br.com.interfision.interfision.api.pacientes.controllers;


import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.interfision.interfision.api.pacientes.assemblers.PacienteAssembler;
import br.com.interfision.interfision.api.pacientes.dtos.PacienteRequest;
import br.com.interfision.interfision.api.pacientes.dtos.PacienteResponse;
import br.com.interfision.interfision.api.pacientes.mappers.PacienteMapper;
import br.com.interfision.interfision.core.exceptions.PacienteNotFoundException;
import br.com.interfision.interfision.core.repositories.PacienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteRestController {

    private final PacienteMapper pacienteMapper;
    private final PacienteAssembler pacienteAssembler;
    private final PacienteRepository pacienteRepository;
    private final PagedResourcesAssembler<PacienteResponse> pagedResourcesAssembler;

    @GetMapping
    public CollectionModel<EntityModel<PacienteResponse>> findAll(Pageable pageable) {
        var pacientes = pacienteRepository.findAll(pageable)
            .map(pacienteMapper::toPacienteResponse);
        return pagedResourcesAssembler.toModel(pacientes, pacienteAssembler);
    }

    @GetMapping("/{id}")
    public EntityModel<PacienteResponse> findById(@PathVariable Long id) {
        var paciente = pacienteRepository.findById(id)
            .orElseThrow(PacienteNotFoundException::new);
        var pacienteResponse = pacienteMapper.toPacienteResponse(paciente);
        return pacienteAssembler.toModel(pacienteResponse);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntityModel<PacienteResponse> create(@RequestBody @Valid PacienteRequest pacienteRequest) {
        var paciente = pacienteMapper.toPaciente(pacienteRequest);
        paciente = pacienteRepository.save(paciente);
        var pacienteResponse = pacienteMapper.toPacienteResponse(paciente);
        return pacienteAssembler.toModel(pacienteResponse);
    }

    @PutMapping("/{id}")
    public EntityModel<PacienteResponse> update(
        @RequestBody @Valid PacienteRequest pacienteRequest, 
        @PathVariable Long id
    ) {
        var paciente = pacienteRepository.findById(id)
            .orElseThrow(PacienteNotFoundException::new);
        var pacienteData = pacienteMapper.toPaciente(pacienteRequest);
        BeanUtils.copyProperties(pacienteData, paciente, "id");
        paciente = pacienteRepository.save(paciente);
        var pacienteResponse = pacienteMapper.toPacienteResponse(paciente);
        return pacienteAssembler.toModel(pacienteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var paciente = pacienteRepository.findById(id)
            .orElseThrow(PacienteNotFoundException::new);
        pacienteRepository.delete(paciente);
        return ResponseEntity.noContent().build();
    }
}
