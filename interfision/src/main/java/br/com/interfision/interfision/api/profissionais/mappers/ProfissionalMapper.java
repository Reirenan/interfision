package br.com.interfision.interfision.api.profissionais.mappers;

import br.com.interfision.interfision.api.profissionais.dtos.ProfissionalRequest;
import br.com.interfision.interfision.api.profissionais.dtos.ProfissionalResponse;
import br.com.interfision.interfision.core.models.Profissional;

public interface ProfissionalMapper {
    Profissional toProfissional(ProfissionalRequest profissionalRequest);
    ProfissionalResponse toProfissionalResponse(Profissional profissional);
}
