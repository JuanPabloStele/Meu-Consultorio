package com.Juan.Meu_Consultorio.controller;


import com.Juan.Meu_Consultorio.infrastructure.entity.AgendamentoEntity;
import com.Juan.Meu_Consultorio.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final DataSource dataSource;

    @PutMapping
    public ResponseEntity<AgendamentoEntity> salvarAgendamento(@RequestBody AgendamentoEntity agendamento){
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente,
                                                   @RequestParam LocalDateTime dataHoraAgendamento){

        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<AgendamentoEntity> buscarAgendamentoDoDia(LocalDate data){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentoDoDia(data));
    }

    @PutMapping
    public ResponseEntity<AgendamentoEntity> alterarAgendamento(@RequestBody AgendamentoEntity agendamento,
                                                                @RequestParam String cliente,
                                                                @RequestParam LocalDateTime dataHoraAgendamento){
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento,cliente,dataHoraAgendamento));

    }
}
