package br.com.interfision.interfision.api.responsaveis.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelRequest;
import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelResponse;
import br.com.interfision.interfision.core.models.Responsavel;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperResponsavelMapper implements ResponsavelMapper {

    private final ModelMapper modelMapper;

    @Override
    public Responsavel toResponsavel(ResponsavelRequest responsavelRequest) {
        return modelMapper.map(responsavelRequest, Responsavel.class);
    }

    @Override
    public ResponsavelResponse toResponsavelResponse(Responsavel responsavel) {
        return modelMapper.map(responsavel, ResponsavelResponse.class);
    }
}
