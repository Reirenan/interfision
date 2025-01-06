package br.com.interfision.interfision.api.consultas.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.consultas.dtos.ConsultaRequest;
import br.com.interfision.interfision.api.consultas.dtos.ConsultaResponse;
import br.com.interfision.interfision.core.models.Consulta;
import br.com.interfision.interfision.core.models.Especialidade;
import br.com.interfision.interfision.core.models.Paciente;
import br.com.interfision.interfision.core.models.Profissional;
import br.com.interfision.interfision.core.repositories.EspecialidadeRepository;
import br.com.interfision.interfision.core.repositories.PacienteRepository;
import br.com.interfision.interfision.core.repositories.ProfissionalRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperConsultaMapper implements ConsultaMapper {

    private final PacienteRepository pacienteRepository;
    private final ProfissionalRepository profissionalRepository;
    private final EspecialidadeRepository especialidadeRepository;

    // Converte ConsultaRequest em Consulta
    public Consulta toConsulta(ConsultaRequest consultaRequest) {
        // Criação manual do objeto Consulta
        Consulta consulta = new Consulta();

        // Buscar Paciente pelo ID no Request
        if (consultaRequest.getPacienteId() != null) {
            Paciente paciente = pacienteRepository.findById(consultaRequest.getPacienteId())
                    .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado para o ID: " + consultaRequest.getPacienteId()));
            consulta.setPaciente(paciente);
        } else {
            throw new IllegalArgumentException("Paciente ID não pode ser nulo.");
        }

        // Buscar Profissional pelo ID no Request
        if (consultaRequest.getProfissionalId() != null) {
            Profissional profissional = profissionalRepository.findById(consultaRequest.getProfissionalId())
                    .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado para o ID: " + consultaRequest.getProfissionalId()));
            consulta.setProfissional(profissional);
        } else {
            throw new IllegalArgumentException("Profissional ID não pode ser nulo.");
        }

        // Buscar Especialidade pelo ID no Request
        if (consultaRequest.getEspecialidadeId() != null) {
            Especialidade especialidade = especialidadeRepository.findById(consultaRequest.getEspecialidadeId())
                    .orElseThrow(() -> new IllegalArgumentException("Especialidade não encontrada para o ID: " + consultaRequest.getEspecialidadeId()));
            consulta.setEspecialidade(especialidade);
        } else {
            throw new IllegalArgumentException("Especialidade ID não pode ser nulo.");
        }

        // Atribuir manualmente os outros campos
        consulta.setData(consultaRequest.getData());
        consulta.setHorario(consultaRequest.getHorario());
        consulta.setObservacoes(consultaRequest.getObservacoes());
        consulta.setStatus(consultaRequest.getStatus());

        return consulta;
    }

    // Converte Consulta em ConsultaResponse
    public ConsultaResponse toConsultaResponse(Consulta consulta) {
        // Criação manual do objeto ConsultaResponse
        ConsultaResponse response = new ConsultaResponse();

        response.setId(consulta.getId());

        // Mapear Paciente
        if (consulta.getPaciente() != null) {
            Paciente pacienteResponse = new Paciente();
            pacienteResponse.setId(consulta.getPaciente().getId());
            pacienteResponse.setNome(consulta.getPaciente().getNome());
            pacienteResponse.setDataNascimento(consulta.getPaciente().getDataNascimento());
            pacienteResponse.setTelefone(consulta.getPaciente().getTelefone());
            pacienteResponse.setEndereco(consulta.getPaciente().getEndereco());
            response.setPacienteId(pacienteResponse);
        }

        // Mapear Profissional
        if (consulta.getProfissional() != null) {
            Profissional profissionalResponse = new Profissional();
            profissionalResponse.setId(consulta.getProfissional().getId());
            profissionalResponse.setNome(consulta.getProfissional().getNome());
            profissionalResponse.setDataNascimento(consulta.getProfissional().getDataNascimento());
            profissionalResponse.setTelefone(consulta.getProfissional().getTelefone());
            profissionalResponse.setEmail(consulta.getProfissional().getEmail());
            profissionalResponse.setRegistroProfissional(consulta.getProfissional().getRegistroProfissional());
            profissionalResponse.setAnosExperiencia(consulta.getProfissional().getAnosExperiencia());
            profissionalResponse.setSalario(consulta.getProfissional().getSalario());
            response.setProfissionalId(profissionalResponse);
        }

        // Mapear Especialidade
        if (consulta.getEspecialidade() != null) {
            Especialidade especialidadeResponse = new Especialidade();
            especialidadeResponse.setId(consulta.getEspecialidade().getId());
            especialidadeResponse.setNome(consulta.getEspecialidade().getNome());
            especialidadeResponse.setDescricao(consulta.getEspecialidade().getDescricao());
            especialidadeResponse.setPrecoEspecialidade(consulta.getEspecialidade().getPrecoEspecialidade());
            response.setEspecialidadeId(especialidadeResponse);
        }

        // Atribuir manualmente os outros campos
        response.setData(consulta.getData());
        response.setHorario(consulta.getHorario());
        response.setObservacoes(consulta.getObservacoes());
        response.setStatus(consulta.getStatus());
        response.setPrecoConsulta(consulta.getPrecoConsulta());
        return response;
    }
}