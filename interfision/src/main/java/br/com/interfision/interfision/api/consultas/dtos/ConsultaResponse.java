package br.com.interfision.interfision.api.consultas.dtos;

import br.com.interfision.interfision.api.pacientes.dtos.PacienteConsultaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponse {

    private Long id;
    private Double precoConsulta;
    private String dataConsulta;
    private String horario;
    private String tipoConsulta;
    private String descricao;
    private PacienteConsultaResponse paciente;
}