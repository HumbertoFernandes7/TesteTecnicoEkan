package br.com.ekan.testedev.mappers;

import br.com.ekan.testedev.dtos.inputs.CondicaoOutput;
import br.com.ekan.testedev.entities.CondicaoEmbeddedEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class CondicaoMapper {

    private final CidMapper cidMapper;

    public CondicaoOutput entityToOutput(CondicaoEmbeddedEntity condicao) {
        CondicaoOutput condicaoOutput = new CondicaoOutput();
        condicaoOutput.setAnotacao(condicao.getAnotacao());
        condicaoOutput.setCid(cidMapper.entityToOutput(condicao.getCid()));
        return condicaoOutput;
    }

    public List<CondicaoOutput> listEntityToListOutput(List<CondicaoEmbeddedEntity> entities) {
        return entities.stream()
                .map(this::entityToOutput)
                .collect(Collectors.toList());
    }
}