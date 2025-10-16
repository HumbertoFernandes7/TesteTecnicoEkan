package br.com.ekan.testedev.services;

import br.com.ekan.testedev.entities.PacienteEntity;
import br.com.ekan.testedev.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteEntity create(PacienteEntity pacienteEntity) {
      return pacienteRepository.save(pacienteEntity);
    }

    public PacienteEntity findById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

    }

    public List<PacienteEntity> findAll(){
        return pacienteRepository.findAll();
    }

    public PacienteEntity update(PacienteEntity pacienteEntity) {
        return  pacienteRepository.save(pacienteEntity);
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }
}