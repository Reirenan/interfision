package br.com.interfision.interfision.api.especialidades.mappers;

import org.springframework.stereotype.Component;
import br.com.interfision.interfision.api.especialidades.dtos.EspecialidadeRequest;
import br.com.interfision.interfision.api.especialidades.dtos.EspecialidadeResponse;
import br.com.interfision.interfision.core.models.Especialidade;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperEspecialidadeMapper implements EspecialidadeMapper {

    public Especialidade toEspecialidade(EspecialidadeRequest especialidadeRequest) {
        Especialidade especialidade = new Especialidade();

        especialidade.setNome(especialidadeRequest.getNome());
        especialidade.setDescricao(especialidadeRequest.getDescricao());
        especialidade.setPrecoEspecialidade(especialidadeRequest.getPrecoEspecialidade());
        return especialidade;
    }

    @Override
    public EspecialidadeResponse toEspecialidadeResponse(Especialidade especialidade) {
        EspecialidadeResponse response = new EspecialidadeResponse();

        response.setId(especialidade.getId());
        response.setNome(especialidade.getNome());
        response.setDescricao(especialidade.getDescricao());
        response.setPrecoEspecialidade(especialidade.getPrecoEspecialidade());
      
        return response;
    }
}
