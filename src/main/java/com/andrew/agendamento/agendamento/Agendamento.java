package com.andrew.agendamento.agendamento;

import com.andrew.agendamento.medico.Medico;
import com.andrew.agendamento.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @FutureOrPresent(message =  "A data e hora do agendamento não podem ser no passado")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

}
