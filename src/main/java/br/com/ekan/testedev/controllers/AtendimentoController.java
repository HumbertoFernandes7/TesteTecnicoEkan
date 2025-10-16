package br.com.ekan.testedev.controllers;

import br.com.ekan.testedev.controllers.docs.AtendimentoControllerDoc;
import br.com.ekan.testedev.dtos.inputs.AtendimentoInput;
import br.com.ekan.testedev.dtos.outputs.AtendimentoOutput;
import br.com.ekan.testedev.dtos.outputs.CondicaoOutput;
import br.com.ekan.testedev.entities.AtendimentoEntity;
import br.com.ekan.testedev.entities.CidEntity;
import br.com.ekan.testedev.entities.CondicaoEmbeddedEntity;
import br.com.ekan.testedev.entities.PacienteEntity;
import br.com.ekan.testedev.mappers.AtendimentoMapper;
import br.com.ekan.testedev.mappers.CondicaoMapper;
import br.com.ekan.testedev.services.AtendimentoService;
import br.com.ekan.testedev.services.CidService;
import br.com.ekan.testedev.services.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
@RequiredArgsConstructor
public class AtendimentoController implements AtendimentoControllerDoc {

    private final AtendimentoService atendimentoService;
    private final AtendimentoMapper atendimentoMapper;
    private final CondicaoMapper condicaoMapper;
    private final PacienteService pacienteService;
    private final CidService cidService;

    @PostMapping
    public ResponseEntity<AtendimentoOutput> create(@RequestBody @Valid AtendimentoInput atendimentoInput) {
        PacienteEntity pacienteEncontrado = pacienteService.findById(atendimentoInput.getPacienteId());
        CidEntity cidEncontrado = cidService.findById(atendimentoInput.getCidId());
        AtendimentoEntity atendimentoEntity = atendimentoMapper.inputToEntity(atendimentoInput, pacienteEncontrado, cidEncontrado);
        AtendimentoEntity atendimentoSalvo = atendimentoService.create(atendimentoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(atendimentoMapper.entityToOutput(atendimentoSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoOutput> findById(@PathVariable Long id){
        AtendimentoEntity atendimentoEncontrado = atendimentoService.findById(id);
        return ResponseEntity.ok(atendimentoMapper.entityToOutput(atendimentoEncontrado));
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoOutput>> findAll(){
        List<AtendimentoEntity> atendimentosEncontrados = atendimentoService.findAll();
        return ResponseEntity.ok().body(atendimentoMapper.listEntityToListOutput(atendimentosEncontrados));
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<CondicaoOutput>> findCondicoesByPaciente(@PathVariable Long id){
        PacienteEntity pacienteEncontrado = pacienteService.findById(id);
        List<CondicaoEmbeddedEntity> condicoesEncontradas = atendimentoService.findCondicoesByPaciente(pacienteEncontrado);
        return ResponseEntity.ok().body(condicaoMapper.listEntityToListOutput(condicoesEncontradas));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoOutput> update(@PathVariable Long id, @RequestBody @Valid AtendimentoInput atendimentoInput){
        AtendimentoEntity atendimentoEncontrado = atendimentoService.findById(id);
        CidEntity cidEncontrado = cidService.findById(atendimentoInput.getCidId());
        PacienteEntity pacienteEncontrado = pacienteService.findById(atendimentoInput.getPacienteId());
        atendimentoMapper.copyInputToEntity(atendimentoInput, atendimentoEncontrado, cidEncontrado, pacienteEncontrado);
        AtendimentoEntity atendimentoAtualizado = atendimentoService.update(atendimentoEncontrado);
        return ResponseEntity.ok(atendimentoMapper.entityToOutput(atendimentoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        atendimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}