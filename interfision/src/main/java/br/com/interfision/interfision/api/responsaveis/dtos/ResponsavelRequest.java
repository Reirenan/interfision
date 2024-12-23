package br.com.interfision.interfision.api.responsaveis.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelRequest {

    @NotBlank(message = "O nome não pode estar vazio.")
    @Size(max = 45, message = "O nome não pode ter mais de 45 caracteres.")
    private String nome;

    @NotBlank(message = "A data de nascimento não pode estar vazia.")
    private String dataNascimento;

    @NotBlank(message = "O telefone não pode estar vazio.")
    private String telefone;

    @NotBlank(message = "O endereço não pode estar vazio.")
    @Size(max = 100, message = "O endereço não pode ter mais de 100 caracteres.")
    private String endereco;

    @Email(message = "O email deve ser válido.")
    @NotBlank(message = "O email não pode estar vazio.")
    private String email;

}