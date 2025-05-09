package com.andrew.agendamento.agendamento;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController  {
    private final AgendamentoService agendamentoService;

      @PostMapping
   public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamento){
      agendamentoService.salvar(agendamento);
      return ResponseEntity.ok (agendamento);
      }
      @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable Long id){
          return ResponseEntity.ok(agendamentoService.buscarPorId(id));
      }

      @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar (@PathVariable Long id, @RequestBody Agendamento novoAgendamento){
          return ResponseEntity.ok(agendamentoService.atualizar(id,novoAgendamento));
      }

      @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
          agendamentoService.deletar(id);
          return ResponseEntity.noContent().build();
      }
      @GetMapping

    public ResponseEntity<List<Agendamento>> listarTodos(){
          return ResponseEntity.ok(agendamentoService.listarTodos());
      }

}

