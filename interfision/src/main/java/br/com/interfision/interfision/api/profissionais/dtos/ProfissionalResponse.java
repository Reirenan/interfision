package br.com.interfision.interfision.api.profissionais.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalResponse {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String email; // Adicionado campo email, caso seja necessário para profissionais
    private String registroProfissional; // Adicionado campo para o registro profissional
    private Integer anosExperiencia; // Adicionado campo para anos de experiência
    private Double salario; // Adicionado campo para salário
}
