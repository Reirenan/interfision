package br.com.interfision.interfision.api.consultas.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequest {

    @NotNull(message = "O ID do paciente não pode estar vazio.")
    private Long pacienteId;

    @NotNull(message = "O ID do profissional não pode estar vazio.")
    private Long profissionalId;

    @NotNull(message = "A data da consulta não pode estar vazia.")
    private LocalDate data; // Data da consulta

    @NotNull(message = "O horário da consulta não pode estar vazio.")
    private LocalTime horario; // Horário da consulta

    @Size(max = 500, message = "As observações não podem ter mais que 500 caracteres.")
    private String observacoes; // Observações adicionais sobre a consulta

    @NotNull(message = "O status da consulta não pode estar vazio.")
    @Size(max = 50, message = "O status não pode ter mais que 50 caracteres.")
    private String status; // Status da consulta (ex.: "Agendada", "Concluída", "Cancelada")
}
