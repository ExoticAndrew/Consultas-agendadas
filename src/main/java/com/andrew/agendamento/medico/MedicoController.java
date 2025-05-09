package com.andrew.agendamento.medico;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService service;

    @PostMapping
    public ResponseEntity<Medico> salvar(@RequestBody Medico medico) {
        service.salvar(medico);
        return ResponseEntity.ok(medico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizar(@PathVariable Long id, @RequestBody Medico medicoAtualizado) {
        return ResponseEntity.ok(service.atualizar(id, medicoAtualizado));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarTodosMedicos() {
        return ResponseEntity.ok(service.listarTodosMedicos());
    }
}
