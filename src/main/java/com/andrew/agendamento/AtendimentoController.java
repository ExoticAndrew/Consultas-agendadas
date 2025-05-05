package com.andrew.agendamento;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atendimentos")
public class AtendimentoController {
    private final AtendimentoService atendimentoService;

    @PostMapping
    public ResponseEntity<Atendimento> salvar(@RequestBody Atendimento atendimento){
        atendimentoService.salvar(atendimento);
        return ResponseEntity.ok(atendimento);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> buscarPorId(@PathVariable Long id){
    return ResponseEntity.ok(atendimentoService.buscarPorId(id));

    }
    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> atualizar(@PathVariable Long id, @RequestBody Atendimento novoAtendimento){
        return ResponseEntity.ok(atendimentoService.atualizar(id, novoAtendimento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        atendimentoService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}
