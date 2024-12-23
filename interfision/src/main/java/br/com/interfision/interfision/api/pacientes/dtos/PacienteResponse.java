package br.com.interfision.interfision.api.pacientes.dtos;

import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String telefone;
    private String endereco;
    private ResponsavelResponse responsavel;
}
