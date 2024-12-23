package br.com.interfision.interfision.api.pacientes.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.pacientes.dtos.PacienteRequest;
import br.com.interfision.interfision.api.pacientes.dtos.PacienteResponse;
import br.com.interfision.interfision.core.models.Paciente;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperPacienteMapper implements PacienteMapper{
    
    
        private final ModelMapper modelMapper;
    
        public Paciente toPaciente(PacienteRequest pacienteRequest) {
            return modelMapper.map(pacienteRequest, Paciente.class);
        }
    
        public PacienteResponse toPacienteResponse(Paciente paciente) {
            return modelMapper.map(paciente, PacienteResponse.class);
        }
    
    }
