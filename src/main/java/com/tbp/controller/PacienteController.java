package com.tbp.controller;

import com.tbp.model.Paciente;
import com.tbp.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("cadastro")
    public String paginaCadastro() {
        return "paciente/cadastro";
    }

    @PostMapping("cadastro")
    public String cadastrar(
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf,
            @RequestParam("planoSaude") String planoSaude, Map<String, Object> model) {

        Paciente paciente = new Paciente();
        paciente.setCpf(cpf);
        paciente.setPlanoSaude(planoSaude);
        paciente.setNome(nome);

        pacienteRepository.save(paciente);
        model.put("mensagem", "Paciente " + nome + " cadastrado com sucesso");
        return "paciente/cadastro";
    }



}
