package br.com.ekan.testedev.controllers.docs;

import br.com.ekan.testedev.dtos.inputs.AtendimentoInput;
import br.com.ekan.testedev.dtos.outputs.AtendimentoOutput;
import br.com.ekan.testedev.dtos.outputs.CondicaoOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Atendimentos", description = "Operações relacionadas ao atendimento de pacientes")
public interface AtendimentoControllerDoc {

    @Operation(summary = "Criar um atendimento médico", description = "cadastrar um novo atendimento medico no sistema")
    @PostMapping
    ResponseEntity<AtendimentoOutput> create(@RequestBody @Valid AtendimentoInput atendimentoInput);

    @Operation(summary = "Busca um atendimento pelo Id", description = "Busca um atendimento pelo Id no banco de dados")
    @GetMapping("/{id}")
    ResponseEntity<AtendimentoOutput> findById(@PathVariable Long id);

    @Operation(summary = "Busca todos os atendimentos", description = "Busca todos os atendimentos no banco de dados")
    @GetMapping
    ResponseEntity<List<AtendimentoOutput>> findAll();

    @Operation(summary = "Busca as condições de um paciente", description = "Busca todas as condições de um paciente no banco de dados pelo seu Id")
    @GetMapping("/paciente/{id}")
    ResponseEntity<List<CondicaoOutput>> findCondicoesByPaciente(@PathVariable Long id);

    @Operation(summary = "Atualiza um atendimento", description = "Atualiza um atendimento pelo Id no banco de dados")
    @PutMapping("/{id}")
    ResponseEntity<AtendimentoOutput> update(@PathVariable Long id, @RequestBody @Valid AtendimentoInput atendimentoInput);

    @Operation(summary = "Deleta um atendimento", description = "Deleta um atendimento pelo Id no banco de dados")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
