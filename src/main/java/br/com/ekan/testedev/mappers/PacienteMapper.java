package br.com.ekan.testedev.mappers;

import br.com.ekan.testedev.dtos.inputs.PacienteInput;
import br.com.ekan.testedev.dtos.outputs.PacienteOutput;
import br.com.ekan.testedev.entities.PacienteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PacienteOutput> listEntityToListOutput(List<PacienteEntity> pacientesEntity){
        return pacientesEntity.stream()
                .map(this::entityToOutput)
                .collect(Collectors.toList());
    }

    public void copyToEntity(PacienteInput pacienteInput, PacienteEntity pacienteEncontrado) {
        pacienteEncontrado.setNome(pacienteInput.getNome());
    }
}
