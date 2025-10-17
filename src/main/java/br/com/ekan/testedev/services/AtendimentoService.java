package br.com.ekan.testedev.services;

import br.com.ekan.testedev.entities.AtendimentoEntity;
import br.com.ekan.testedev.entities.CondicaoEmbeddedEntity;
import br.com.ekan.testedev.entities.PacienteEntity;
import br.com.ekan.testedev.repositories.AtendimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final EmailService emailService;

    public AtendimentoEntity create(AtendimentoEntity atendimentoEntity){
        AtendimentoEntity atendimentoSalvo = atendimentoRepository.save(atendimentoEntity);
        emailService.enviarEmailAtendimento(atendimentoSalvo);
        return atendimentoSalvo;
    }

    public AtendimentoEntity findById(Long id){
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atendimento não encontrado"));
    }

    public List<AtendimentoEntity> findAll(){
        return  atendimentoRepository.findAll();
    }

    public List<CondicaoEmbeddedEntity> findCondicoesByPaciente(PacienteEntity pacienteEntity){
        List<AtendimentoEntity> atendimentos = atendimentoRepository.findAllByPaciente(pacienteEntity);
        return atendimentos.stream()
                .map(AtendimentoEntity::getCondicao)
                .collect(Collectors.toList());
    }

    public AtendimentoEntity update(AtendimentoEntity atendimentoEntity){
        return atendimentoRepository.save(atendimentoEntity);
    }

    public void delete(Long id){
        atendimentoRepository.deleteById(id);
    }
}
