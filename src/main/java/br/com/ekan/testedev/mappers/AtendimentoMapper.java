package br.com.ekan.testedev.mappers;

import br.com.ekan.testedev.dtos.inputs.AtendimentoInput;
import br.com.ekan.testedev.dtos.inputs.AtendimentoOutput;
import br.com.ekan.testedev.entities.AtendimentoEntity;
import br.com.ekan.testedev.entities.CidEntity;
import br.com.ekan.testedev.entities.CondicaoEmbeddedEntity;
import br.com.ekan.testedev.entities.PacienteEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AtendimentoMapper {

    private final CondicaoMapper condicaoMapper;
    private final CidMapper cidMapper;

    public AtendimentoEntity inputToEntity(AtendimentoInput atendimentoInput, PacienteEntity pacienteEncontrado, CidEntity cidEncontrado) {

        CondicaoEmbeddedEntity condicao = new CondicaoEmbeddedEntity();
        condicao.setAnotacao(atendimentoInput.getAnotacao());
        condicao.setCid(cidEncontrado);
        AtendimentoEntity atendimentoEntity = new AtendimentoEntity();
        atendimentoEntity.setPaciente(pacienteEncontrado);
        atendimentoEntity.setDataAtendimento(LocalDateTime.now());
        atendimentoEntity.setCondicao(condicao);
        return atendimentoEntity;
    }

    public AtendimentoOutput entityToOutput(AtendimentoEntity atendimentoSalvo) {
        AtendimentoOutput atendimentoOutput = new AtendimentoOutput();
        atendimentoOutput.setId(atendimentoSalvo.getId());
        atendimentoOutput.setPacienteId(atendimentoSalvo.getPaciente().getId());
        atendimentoOutput.setDataAtendimento(atendimentoSalvo.getDataAtendimento());
        atendimentoOutput.setCondicao(condicaoMapper.entityToOutput(atendimentoSalvo.getCondicao()));
        return atendimentoOutput;
    }

    public List<AtendimentoOutput> listEntityToListOutput(List<AtendimentoEntity> atendimentosEncontrados) {
        return atendimentosEncontrados.stream()
                .map(this::entityToOutput)
                .collect(Collectors.toList());
    }

    public void copyInputToEntity(AtendimentoInput atendimentoInput, AtendimentoEntity atendimentoEncontrado, CidEntity cidEncontrado, PacienteEntity pacienteEncontrado) {
        CondicaoEmbeddedEntity condicao = new CondicaoEmbeddedEntity();
        condicao.setAnotacao(atendimentoInput.getAnotacao());
        condicao.setCid(cidEncontrado);
        atendimentoEncontrado.setPaciente(pacienteEncontrado);
        atendimentoEncontrado.setCondicao(condicao);
    }
}