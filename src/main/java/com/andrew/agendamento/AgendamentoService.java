package com.andrew.agendamento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final AgendamentoRepository repository;

    public void salvar(Agendamento agendamento) {
        repository.save(agendamento);
    }

    public Agendamento buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
    }

    public Agendamento atualizar(Long id, Agendamento novoagendamento) {
        Agendamento agendamento = buscarPorId(id);
        agendamento.setDataHora(novoagendamento.getDataHora());
        agendamento.setMedico(novoagendamento.getMedico());
        agendamento.setPaciente(novoagendamento.getPaciente());
        return repository.save(agendamento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

}
