package br.com.interfision.interfision.api.especialidades.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.interfision.interfision.api.especialidades.assemblers.EspecialidadeAssembler;
import br.com.interfision.interfision.api.especialidades.dtos.EspecialidadeRequest;
import br.com.interfision.interfision.api.especialidades.dtos.EspecialidadeResponse;
import br.com.interfision.interfision.api.especialidades.mappers.EspecialidadeMapper;
import br.com.interfision.interfision.core.exceptions.EspecialidadeNotFoundException;
import br.com.interfision.interfision.core.repositories.EspecialidadeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/especialidades")
public class EspecialidadeRestController {

    private static final Logger logger = LoggerFactory.getLogger(EspecialidadeRestController.class);

    private final EspecialidadeMapper especialidadeMapper;
    private final EspecialidadeAssembler especialidadeAssembler;
    private final EspecialidadeRepository especialidadeRepository;
    private final PagedResourcesAssembler<EspecialidadeResponse> pagedResourcesAssembler;

    @GetMapping
    public CollectionModel<EntityModel<EspecialidadeResponse>> findAll(Pageable pageable) {
        logger.info("Fetching all especialidades with pagination: {}", pageable);
        var especialidades = especialidadeRepository.findAll(pageable)
            .map(especialidadeMapper::toEspecialidadeResponse);
        return pagedResourcesAssembler.toModel(especialidades, especialidadeAssembler);
    }

    @GetMapping("/{id}")
    public EntityModel<EspecialidadeResponse> findById(@PathVariable Long id) {
        logger.info("Fetching especialidade by ID: {}", id);
        var especialidade = especialidadeRepository.findById(id)
            .orElseThrow(() -> new EspecialidadeNotFoundException("Especialidade não encontrada para o ID: " + id));
        var especialidadeResponse = especialidadeMapper.toEspecialidadeResponse(especialidade);
        return especialidadeAssembler.toModel(especialidadeResponse);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntityModel<EspecialidadeResponse> create(@RequestBody @Valid EspecialidadeRequest especialidadeRequest) {
        logger.info("Creating especialidade: {}", especialidadeRequest);
        var especialidade = especialidadeMapper.toEspecialidade(especialidadeRequest);
        especialidade = especialidadeRepository.save(especialidade);
        var especialidadeResponse = especialidadeMapper.toEspecialidadeResponse(especialidade);
        return especialidadeAssembler.toModel(especialidadeResponse);
    }

    @PutMapping("/{id}")
    public EntityModel<EspecialidadeResponse> update(
        @RequestBody @Valid EspecialidadeRequest especialidadeRequest,
        @PathVariable Long id
    ) {
        logger.info("Updating especialidade with ID: {}", id);
        var especialidade = especialidadeRepository.findById(id)
            .orElseThrow(() -> new EspecialidadeNotFoundException("Especialidade não encontrada para o ID: " + id));
        var especialidadeData = especialidadeMapper.toEspecialidade(especialidadeRequest);
        BeanUtils.copyProperties(especialidadeData, especialidade, "id");
        especialidade = especialidadeRepository.save(especialidade);
        var especialidadeResponse = especialidadeMapper.toEspecialidadeResponse(especialidade);
        return especialidadeAssembler.toModel(especialidadeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting especialidade with ID: {}", id);
        var especialidade = especialidadeRepository.findById(id)
            .orElseThrow(() -> new EspecialidadeNotFoundException("Especialidade não encontrada para o ID: " + id));
        especialidadeRepository.delete(especialidade);
        return ResponseEntity.noContent().build();
    }
}
