package br.com.interfision.interfision.api.pacientes.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequest {

    @NotEmpty(message = "O nome não pode estar vazio.")
    @Size(max = 45, message = "O nome não pode ter mais de 45 caracteres.")
    private String nome;

    @NotEmpty(message = "A data de nascimento não pode estar vazia.")
    private String dataNascimento;

    @NotEmpty(message = "O telefone não pode estar vazio.")
    @Size(max = 20, message = "O telefone não pode ter mais de 20 caracteres.")
    private String telefone;

    @NotEmpty(message = "O endereço não pode estar vazio.")
    @Size(max = 100, message = "O endereço não pode ter mais de 100 caracteres.")
    private String endereco;

    private Long responsavelId; // ID do responsável (opcional, depende do caso de uso)
}
