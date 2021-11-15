package com.tbp.controller;

import com.tbp.model.Agendamento;
import com.tbp.model.Exame;
import com.tbp.model.Medico;
import com.tbp.model.Paciente;
import com.tbp.repository.AgendamentoRepository;
import com.tbp.repository.ExameRepository;
import com.tbp.repository.MedicoRepository;
import com.tbp.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ExameRepository exameRepository;

    @GetMapping("list")
    public String paginaListagem(Map<String, Object> model) {
        model.put("agendamentoList", agendamentoRepository.findAll());
        return "agendamento/list";
    }


    @GetMapping("cadastro")
    public String paginaCadastro(Map<String, Object> model) {
        model.put("medicoList", medicoRepository.findAll());
        model.put("pacienteList", pacienteRepository.findAll());
        model.put("exameList", exameRepository.findAll());
        return "agendamento/cadastro";
    }

    @PostMapping("cadastro")
    public String cadastrar(
            @RequestParam("idMedico") Integer idMedico,
            @RequestParam("idPaciente") Integer idPaciente,
            @RequestParam("idExame") Integer idExame,
            @RequestParam("horario") String horario,
            Map<String, Object> model) {

        Medico medico = medicoRepository.findOne(idMedico);
        Paciente paciente = pacienteRepository.findOne(idPaciente);
        Exame exame = exameRepository.findOne(idExame);

        Agendamento agendamento = new Agendamento();
        agendamento.setExame(exame);
        agendamento.setMedico(medico);
        agendamento.setPaciente(paciente);
        agendamento.setHorario(horario);

        agendamentoRepository.save(agendamento);
        model.put("mensagem",  "Agendamento cadastrado com sucesso");
        return "exame/cadastro";
    }


}
