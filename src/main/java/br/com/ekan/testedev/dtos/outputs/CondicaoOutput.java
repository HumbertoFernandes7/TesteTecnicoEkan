package br.com.ekan.testedev.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondicaoOutput {

    @Schema(description = "Anotações do médico sobre o diagnóstico", example = "Paciente testa positivo para gripe suína")
    private String anotacao;

    @Schema(description = "Detalhes do código CID-10 associado")
    private CidOutput cid;
}
