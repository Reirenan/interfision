package br.com.interfision.interfision.api.profissionais.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalRequest {

    @NotEmpty(message = "O nome não pode estar vazio.")
    @Size(max = 45, message = "O nome não pode ter mais de 45 caracteres.")
    private String nome;

    @NotEmpty(message = "A data de nascimento não pode estar vazia.")
    private String dataNascimento;

    @NotEmpty(message = "O telefone não pode estar vazio.")
    @Size(max = 20, message = "O telefone não pode ter mais de 20 caracteres.")
    private String telefone;

    @NotEmpty(message = "O e-mail não pode estar vazio.")
    @Email(message = "O e-mail deve ser válido.")
    @Size(max = 100, message = "O e-mail não pode ter mais de 100 caracteres.")
    private String email;

    @NotEmpty(message = "O registro profissional não pode estar vazio.")
    @Size(max = 45, message = "O registro profissional não pode ter mais de 45 caracteres.")
    private String registroProfissional;

    @Positive(message = "Os anos de experiência devem ser um valor positivo.")
    private Integer anosExperiencia;

    @Positive(message = "O salário deve ser um valor positivo.")
    private Double salario;
}
