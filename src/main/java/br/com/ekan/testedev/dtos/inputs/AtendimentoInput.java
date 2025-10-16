package br.com.ekan.testedev.dtos.inputs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtendimentoInput {
    @NotNull(message = "O ID do paciente não pode ser nulo")
    private Long pacienteId;

    @NotNull(message = "A condição não pode ser nula")
    private CondicaoInput condicao;
}
