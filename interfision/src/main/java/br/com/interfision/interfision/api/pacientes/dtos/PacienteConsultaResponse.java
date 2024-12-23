package br.com.interfision.interfision.api.pacientes.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteConsultaResponse {
    private Long id;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String endereco;
}
