package br.com.ekan.testedev.mappers;

import br.com.ekan.testedev.dtos.outputs.CidOutput;
import br.com.ekan.testedev.entities.CidEntity;
import org.springframework.stereotype.Component;

@Component
public class CidMapper {

    public CidOutput entityToOutput(CidEntity cidEntity){
        if (cidEntity == null) {
            return null;
        }
        CidOutput cidOutput = new CidOutput();
        cidOutput.setId(cidEntity.getId());
        cidOutput.setCodigo(cidEntity.getCodigo());
        cidOutput.setNome(cidEntity.getNome());
        return cidOutput;
    }

}
