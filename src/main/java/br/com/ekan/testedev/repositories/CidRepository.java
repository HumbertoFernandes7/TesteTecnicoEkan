package br.com.ekan.testedev.repositories;

import br.com.ekan.testedev.entities.CidEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidRepository extends JpaRepository<CidEntity, Long> {
}
