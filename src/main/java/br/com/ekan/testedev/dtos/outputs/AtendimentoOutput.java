package br.com.ekan.testedev.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AtendimentoOutput {

    @Schema(description = "ID único do atendimento", example = "1")
    private Long id;

    @Schema(description = "ID do paciente associado ao atendimento", example = "1")
    private Long pacienteId;

    @Schema(description = "Data e hora em que o atendimento foi realizado", example = "2024-10-26T10:00:00")
    private LocalDateTime dataAtendimento;

    @Schema(description = "Detalhes da condição diagnosticada no atendimento")
    private CondicaoOutput condicao;

}