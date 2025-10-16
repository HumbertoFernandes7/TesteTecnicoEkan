package br.com.ekan.testedev.services;

import br.com.ekan.testedev.entities.AtendimentoEntity;
import br.com.ekan.testedev.repositories.AtendimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoEntity create(AtendimentoEntity atendimentoEntity){
        return atendimentoRepository.save(atendimentoEntity);
    }

    public AtendimentoEntity findById(Long id){
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atendimento não encontrado"));
    }

    public List<AtendimentoEntity> findAll(){
        return  atendimentoRepository.findAll();
    }

    public AtendimentoEntity update(AtendimentoEntity atendimentoEntity){
        return atendimentoRepository.save(atendimentoEntity);
    }

    public void delete(Long id){
        atendimentoRepository.deleteById(id);
    }
}
