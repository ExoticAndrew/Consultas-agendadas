package com.andrew.agendamento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository repository;
    public void salvar ( Paciente paciente){
    repository.save(paciente);
    }
    public Paciente buscarPorId(Long id){
    return repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Paciente não encontrado"));
    }
    public Paciente atualizar(Long id, Paciente novoPaciente){
        Paciente paciente = buscarPorId(id);
        paciente.setNome(novoPaciente.getNome());
        paciente.setCpf(novoPaciente.getCpf());
        paciente.setDataNascimento(novoPaciente.getDataNascimento());
        return repository.save(paciente);
    }
    public void deletar(Long id){
        repository.deleteById(id);

    }
    public List<Paciente> listarTodosPacientes(){
        return repository.findAll();
    }
}
