package br.com.ekan.testedev.repositories;

import br.com.ekan.testedev.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
