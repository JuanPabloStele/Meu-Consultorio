package com.Juan.Meu_Consultorio.services;


import com.Juan.Meu_Consultorio.infrastructure.entity.AgendamentoEntity;
import com.Juan.Meu_Consultorio.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoEntity salvarAgendamento(AgendamentoEntity agendamento){

        LocalDateTime horaDeAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

        AgendamentoEntity agendados =agendamentoRepository
                .findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), horaDeAgendamento, horaFim);

        if (Objects.nonNull(agendados)){
            throw new RuntimeException("Horário ja está preenchiodo");

        }
        return agendamentoRepository.save(agendamento);


    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente){
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }


}
