package br.com.interfision.interfision.api.especialidades.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeResponse {

    private Long id;
    private String nome; 
    private String descricao; 
    private Double precoEspecialidade; 
}
