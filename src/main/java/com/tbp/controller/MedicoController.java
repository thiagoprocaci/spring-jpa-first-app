package com.tbp.controller;

import com.tbp.model.Medico;
import com.tbp.model.Paciente;
import com.tbp.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("cadastro")
    public String paginaCadastro() {
        return "medico/cadastro";
    }

    @PostMapping("cadastro")
    public String cadastrar(
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf,
            @RequestParam("crm") String crm, Map<String, Object> model) {

        Medico medico = new Medico();
        medico.setCpf(cpf);
        medico.setCrm(crm);
        medico.setNome(nome);

        medicoRepository.save(medico);
        model.put("mensagem", " Medico " + nome + " cadastrado com sucesso");
        return "medico/cadastro";
    }
}
