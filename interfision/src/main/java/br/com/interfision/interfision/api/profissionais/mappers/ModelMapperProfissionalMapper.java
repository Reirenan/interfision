package br.com.interfision.interfision.api.profissionais.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.profissionais.dtos.ProfissionalRequest;
import br.com.interfision.interfision.api.profissionais.dtos.ProfissionalResponse;
import br.com.interfision.interfision.core.models.Profissional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperProfissionalMapper implements ProfissionalMapper {

    private final ModelMapper modelMapper;

    @Override
    public Profissional toProfissional(ProfissionalRequest profissionalRequest) {
        return modelMapper.map(profissionalRequest, Profissional.class);
    }

    @Override
    public ProfissionalResponse toProfissionalResponse(Profissional profissional) {
        return modelMapper.map(profissional, ProfissionalResponse.class);
    }
}
