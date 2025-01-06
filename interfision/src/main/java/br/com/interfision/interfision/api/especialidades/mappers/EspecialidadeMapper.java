package br.com.interfision.interfision.api.especialidades.mappers;

import br.com.interfision.interfision.api.especialidades.dtos.EspecialidadeRequest;
import br.com.interfision.interfision.api.especialidades.dtos.EspecialidadeResponse;
import br.com.interfision.interfision.core.models.Especialidade;

public interface EspecialidadeMapper {
    Especialidade toEspecialidade(EspecialidadeRequest especialidadeRequest);
    EspecialidadeResponse toEspecialidadeResponse(Especialidade especialidade);
}
