package com.andrew.agendamento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtendimentoService {
    private final AtendimentoRepository repository;

    public void salvar(Atendimento atendimento){
        repository.save(atendimento);
    }
    public Atendimento buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Atendimento não encontrado"));

    }
    public Atendimento atualizar(Long id, Atendimento novoAtendimento){
        Atendimento atendimento = buscarPorId(id);
        atendimento.setDescricao(novoAtendimento.getDescricao());
        atendimento.setDataAtendimento(novoAtendimento.getDataAtendimento());
        atendimento.setStatus(novoAtendimento.getStatus());
        return repository.save(atendimento);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
