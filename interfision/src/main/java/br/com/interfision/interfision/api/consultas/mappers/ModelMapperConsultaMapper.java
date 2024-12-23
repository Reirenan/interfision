package br.com.interfision.interfision.api.consultas.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.consultas.dtos.ConsultaRequest;
import br.com.interfision.interfision.api.consultas.dtos.ConsultaResponse;
import br.com.interfision.interfision.core.models.Consulta;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperConsultaMapper implements ConsultaMapper {

    private final ModelMapper modelMapper;

    @Override
    public Consulta toConsulta(ConsultaRequest consultaRequest) {
        return modelMapper.map(consultaRequest, Consulta.class);
    }

    @Override
    public ConsultaResponse toConsultaResponse(Consulta consulta) {
        return modelMapper.map(consulta, ConsultaResponse.class);
    }
}