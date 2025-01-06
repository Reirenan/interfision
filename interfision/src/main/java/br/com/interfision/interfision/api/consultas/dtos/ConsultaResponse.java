package br.com.interfision.interfision.api.consultas.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.interfision.interfision.core.models.Especialidade;
import br.com.interfision.interfision.core.models.Paciente;
import br.com.interfision.interfision.core.models.Profissional;
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
    private BigDecimal precoConsulta; 
    private Paciente pacienteId; 
    private Profissional profissionalId;
    private Especialidade especialidadeId;
    private LocalDate data;
    private LocalTime horario; 
    private String observacoes; 
    private String status; 

}
