package br.com.ekan.testedev.controllers;

import br.com.ekan.testedev.dtos.inputs.PacienteInput;
import br.com.ekan.testedev.dtos.inputs.PacienteOutput;
import br.com.ekan.testedev.entities.PacienteEntity;
import br.com.ekan.testedev.mappers.PacienteMapper;

import br.com.ekan.testedev.services.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteMapper pacienteMapper;
    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteOutput> create(@RequestBody @Valid PacienteInput pacienteInput) {
        PacienteEntity pacienteEntity = pacienteMapper.inputToEntity(pacienteInput);
        PacienteEntity pacienteSalvo = pacienteService.create(pacienteEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteMapper.entityToOutput(pacienteSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteOutput> findById(@PathVariable Long id) {
        PacienteEntity pacienteEntity = pacienteService.findById(id);
        return ResponseEntity.ok(pacienteMapper.entityToOutput(pacienteEntity));
    }

    @GetMapping
    public ResponseEntity<List<PacienteOutput>> findAll() {
        List<PacienteEntity> pacientes = pacienteService.findAll();
        return ResponseEntity.ok().body(pacienteMapper.listEntityToListOutput(pacientes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteOutput> update(@RequestBody @Valid PacienteInput pacienteInput, @PathVariable Long id) {
        PacienteEntity pacienteEncontrado = pacienteService.findById(id);
        pacienteMapper.copyToEntity(pacienteInput, pacienteEncontrado);
        PacienteEntity pacienteAtualizado = pacienteService.update(pacienteEncontrado);
        return ResponseEntity.ok().body(pacienteMapper.entityToOutput(pacienteAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
