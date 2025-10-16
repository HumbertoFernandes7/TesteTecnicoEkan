package br.com.ekan.testedev.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteInput {

    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    private String nome;

}
