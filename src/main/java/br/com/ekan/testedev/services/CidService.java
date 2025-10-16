package br.com.ekan.testedev.services;

import br.com.ekan.testedev.entities.CidEntity;
import br.com.ekan.testedev.repositories.CidRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CidService {

    private final CidRepository cidRepository;

    public CidEntity findById(Long id){
        return cidRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CID não encontrado"));
    }
}
