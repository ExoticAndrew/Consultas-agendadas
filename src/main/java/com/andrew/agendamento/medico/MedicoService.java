package com.andrew.agendamento.medico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository repository;

    public void salvar(Medico medico) {
        repository.save(medico);
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado"));
    }

    public Medico atualizar(Long id, Medico novoMedico) {
        Medico medico = buscarPorId(id);
        medico.setNome(novoMedico.getNome());
        medico.setEspecialidade(novoMedico.getEspecialidade());
        medico.setCrm(novoMedico.getCrm());
        return repository.save(medico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Medico> listarTodosMedicos() {
        return repository.findAll();
    }
}



