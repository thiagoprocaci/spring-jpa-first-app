package com.tbp.controller;

import com.tbp.model.Aluno;
import com.tbp.model.Professor;
import com.tbp.model.Turma;
import com.tbp.repository.AlunoRepository;
import com.tbp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    TurmaRepository turmaRepository;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(Map<String, Object> model) {

        return "aluno/create";
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam("nome") String nome,
                         @RequestParam("matricula") String matricula,
                         @RequestParam(value = "idTurma", required = false) Long idTurma) {

        return "redirect:/aluno/list";

    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {

        return "aluno/list";
    }



}
