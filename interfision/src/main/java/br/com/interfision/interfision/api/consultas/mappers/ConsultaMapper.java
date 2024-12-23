package br.com.interfision.interfision.api.consultas.mappers;

import br.com.interfision.interfision.api.consultas.dtos.ConsultaRequest;
import br.com.interfision.interfision.api.consultas.dtos.ConsultaResponse;
import br.com.interfision.interfision.core.models.Consulta;

public interface ConsultaMapper {
    Consulta toConsulta(ConsultaRequest consultaRequest);
    ConsultaResponse toConsultaResponse(Consulta consulta);
}
