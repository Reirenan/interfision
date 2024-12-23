package br.com.interfision.interfision.api.responsaveis.mappers;

import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelRequest;
import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelResponse;
import br.com.interfision.interfision.core.models.Responsavel;

public interface ResponsavelMapper {
    Responsavel toResponsavel(ResponsavelRequest responsavelRequest);
    ResponsavelResponse toResponsavelResponse(Responsavel responsavel);
}
