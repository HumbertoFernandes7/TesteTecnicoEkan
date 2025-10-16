package br.com.ekan.testedev.controllers.docs;

import br.com.ekan.testedev.dtos.inputs.PacienteInput;
import br.com.ekan.testedev.dtos.outputs.PacienteOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Pacientes", description = "Operações relacionadas aos pacientes")
public interface PacienteControllerDoc {

    @Operation(summary = "Cria um novo paciente", description = "Endpoint para registrar um novo paciente na base de dados.")
    ResponseEntity<PacienteOutput> create(@RequestBody @Valid PacienteInput pacienteInput);

    @Operation(summary = "Busca um paciente pelo ID", description = "Endpoint para obter os detalhes de um paciente específico a partir do seu ID.")
    ResponseEntity<PacienteOutput> findById(@PathVariable Long id);

    @Operation(summary = "Lista todos os pacientes", description = "Endpoint para obter uma lista com todos os pacientes cadastrados.")
    ResponseEntity<List<PacienteOutput>> findAll();

    @Operation(summary = "Atualiza um paciente existente", description = "Endpoint para atualizar os dados de um paciente a partir do seu ID.")
    ResponseEntity<PacienteOutput> update(@RequestBody @Valid PacienteInput pacienteInput, @PathVariable Long id);

    @Operation(summary = "Deleta um paciente pelo ID", description = "Endpoint para remover um paciente da base de dados.")
    ResponseEntity<Void> delete(@PathVariable Long id);
}