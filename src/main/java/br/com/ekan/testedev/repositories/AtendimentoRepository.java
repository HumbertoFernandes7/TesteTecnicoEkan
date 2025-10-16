package br.com.ekan.testedev.repositories;

import br.com.ekan.testedev.entities.AtendimentoEntity;
import br.com.ekan.testedev.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long> {

    List<AtendimentoEntity> findAllByPaciente(PacienteEntity paciente);
}
