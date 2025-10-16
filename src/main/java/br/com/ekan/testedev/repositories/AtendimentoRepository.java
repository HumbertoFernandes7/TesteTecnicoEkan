package br.com.ekan.testedev.repositories;

import br.com.ekan.testedev.entities.AtendimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long> {
}
