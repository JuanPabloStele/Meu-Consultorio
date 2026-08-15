package com.Juan.Meu_Consultorio.services.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento")

public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String servico;

    private String proficional;

    private LocalDateTime dataHoraAgendamento;

    private String cliente;

    private String telefoneCliente;

    private LocalDateTime dataInsercao = LocalDateTime.now();


}
