package br.com.interfision.interfision.api.especialidades.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeRequest {

    @NotNull(message = "O nome da especialidade não pode estar vazio.")
    @Size(max = 45, message = "O nome da especialidade não pode ter mais que 45 caracteres.")
    private String nome; // Nome da especialidade

    @Size(max = 1000, message = "A descrição não pode ter mais que 1000 caracteres.")
    private String descricao; // Descrição da especialidade

    @NotNull(message = "O preço da especialidade não pode estar vazio.")
    @Positive(message = "O preço deve ser um valor positivo.")
    private Double precoEspecialidade; // Preço da especialidade
}
