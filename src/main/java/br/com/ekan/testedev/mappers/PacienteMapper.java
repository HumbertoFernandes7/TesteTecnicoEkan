package br.com.ekan.testedev.mappers;

import br.com.ekan.testedev.dtos.inputs.PacienteInput;
import br.com.ekan.testedev.dtos.inputs.PacienteOutput;
import br.com.ekan.testedev.entities.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteEntity inputToEntity(PacienteInput pacienteInput) {
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setNome(pacienteInput.getNome());
        return pacienteEntity;
    }

    public PacienteOutput entityToOutput(PacienteEntity pacienteEntity) {
        PacienteOutput pacienteOutput = new PacienteOutput();
        pacienteOutput.setId(pacienteEntity.getId());
        pacienteOutput.setNome(pacienteEntity.getNome());
        return pacienteOutput;
    }
}
