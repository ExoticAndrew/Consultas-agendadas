package com.andrew.agendamento.medico;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String especialidade;

    @Column(unique = true)
    private String crm;
}
