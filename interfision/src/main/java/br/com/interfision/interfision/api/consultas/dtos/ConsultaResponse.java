package br.com.interfision.interfision.api.consultas.dtos;

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
    private Paciente pacienteId; 
    private Profissional profissionalId;
}
