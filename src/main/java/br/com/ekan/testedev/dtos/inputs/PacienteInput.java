package br.com.ekan.testedev.dtos.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteInput {

    @Schema(description = "Nome completo do paciente", example = "Humberto Fernandes")
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    private String nome;
}