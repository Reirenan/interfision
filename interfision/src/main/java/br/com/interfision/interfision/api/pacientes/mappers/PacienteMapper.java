package br.com.interfision.interfision.api.pacientes.mappers;

import br.com.interfision.interfision.api.pacientes.dtos.PacienteRequest;
import br.com.interfision.interfision.api.pacientes.dtos.PacienteResponse;
import br.com.interfision.interfision.core.models.Paciente;

public interface PacienteMapper {
    Paciente toPaciente(PacienteRequest pacienteRequest);
    PacienteResponse toPacienteResponse(Paciente paciente);
}
