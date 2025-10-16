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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
