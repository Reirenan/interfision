package br.com.interfision.interfision.api.profissionais.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalConsultaResponse {
    private Long id;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String email; // Adicionado para maior detalhamento
    private String registroProfissional; // Adicionado para identificação do profissional
}
