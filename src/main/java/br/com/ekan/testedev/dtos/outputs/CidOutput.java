package br.com.ekan.testedev.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidOutput {

    @Schema(description = "ID único do CID", example = "1")
    private Long id;

    @Schema(description = "Código da doença (CID-10)", example = "J09")
    private String codigo;

    @Schema(description = "Nome da doença", example = "Influenza due to identified zoonotic or pandemic influenza virus")
    private String nome;

}