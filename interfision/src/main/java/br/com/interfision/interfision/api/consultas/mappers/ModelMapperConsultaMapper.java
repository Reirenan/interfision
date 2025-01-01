package br.com.interfision.interfision.api.consultas.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.consultas.dtos.ConsultaRequest;
import br.com.interfision.interfision.api.consultas.dtos.ConsultaResponse;
import br.com.interfision.interfision.core.models.Consulta;
import br.com.interfision.interfision.core.models.Paciente;
import br.com.interfision.interfision.core.models.Profissional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperConsultaMapper implements ConsultaMapper {

    private final ModelMapper modelMapper;

    public Consulta toConsulta(ConsultaRequest consultaRequest) {
        Consulta consulta = new Consulta();

        // Mapear pacienteId para Paciente
        if (consultaRequest.getPacienteId() != null) {
            Paciente paciente = new Paciente();
            paciente.setId(consultaRequest.getPacienteId());
            consulta.setPaciente(paciente);
        }

        // Mapear profissionalId para Profissional
        if (consultaRequest.getProfissionalId() != null) {
            Profissional profissional = new Profissional();
            profissional.setId(consultaRequest.getProfissionalId());
            consulta.setProfissional(profissional);
        }
        consulta.setData(consultaRequest.getData());
        consulta.setHorario(consultaRequest.getHorario());
        consulta.setObservacoes(consultaRequest.getObservacoes());
        consulta.setStatus(consultaRequest.getStatus());

        return consulta;
    }

    public ConsultaResponse toConsultaResponse(Consulta consulta) {
        return modelMapper.map(consulta, ConsultaResponse.class);
    }
}
