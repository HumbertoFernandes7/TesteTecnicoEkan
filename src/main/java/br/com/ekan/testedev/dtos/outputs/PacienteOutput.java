package br.com.ekan.testedev.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteOutput {

    @Schema(description = "ID único do paciente", example = "1")
    private Long id;

    @Schema(description = "Nome completo do paciente", example = "João da Silva")
    private String nome;
}
