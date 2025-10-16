package br.com.ekan.testedev.dtos.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtendimentoInput {

    @Schema(description = "ID do paciente que está sendo atendido", example = "1")
    @NotNull(message = "O ID do paciente não pode ser nulo")
    private Long pacienteId;

    @Schema(description = "Anotações do médico sobre o diagnóstico", example = "Paciente testa positivo para gripe suína")
    @NotBlank(message = "A anotação não pode ser nula ou vazia")
    private String anotacao;

    @Schema(description = "ID do código CID-10 relacionado ao diagnóstico", example = "1")
    @NotNull(message = "O id do CID não pode ser nulo")
    private Long cidId;
}