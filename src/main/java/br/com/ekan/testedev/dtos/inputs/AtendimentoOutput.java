package br.com.ekan.testedev.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AtendimentoOutput {

    private Long id;
    private Long pacienteId;
    private LocalDateTime dataAtendimento;
    private CondicaoOutput condicao;

}