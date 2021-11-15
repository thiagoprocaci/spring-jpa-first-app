package com.tbp.controller;

import com.tbp.model.Exame;
import com.tbp.model.Paciente;
import com.tbp.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("exame")
public class ExameController {

    @Autowired
    private ExameRepository exameRepository;

    @GetMapping("cadastro")
    public String paginaCadastro() {
        return "exame/cadastro";
    }

    @PostMapping("cadastro")
    public String cadastrar(
            @RequestParam("nome") String nome, Map<String, Object> model) {

        Exame exame = new Exame();
        exame.setNome(nome);

        exameRepository.save(exame);
        model.put("mensagem", nome + " cadastrado com sucesso");
        return "exame/cadastro";
    }


}
