package br.com.ekan.testedev.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondicaoInput {

    @NotBlank(message = "A anotação não pode ser nula ou vazia")
    private String anotacao;

    @NotNull(message = "O id do CID não pode ser nulo")
    private Long cidId;

}
