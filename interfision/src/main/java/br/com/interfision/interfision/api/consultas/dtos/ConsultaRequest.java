package br.com.interfision.interfision.api.consultas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequest {

    private Double precoConsulta;

    @NotNull(message = "A data da consulta não pode estar vazia.")
    private LocalDate dataConsulta;

    @NotNull(message = "O horário da consulta não pode estar vazio.")
    private LocalTime horario;

    @NotBlank(message = "O tipo da consulta não pode estar vazio.")
    @Size(max = 45, message = "O tipo da consulta não pode ter mais de 45 caracteres.")
    private String tipoConsulta;

    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String descricao;

    @NotNull(message = "O ID do paciente não pode estar vazio.")
    private Long pacienteId;
}
