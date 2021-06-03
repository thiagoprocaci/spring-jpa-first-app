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
        Iterable<Turma> all = turmaRepository.findAll();
        model.put("turmaList", all);
        return "aluno/create";
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam("nome") String nome,
                         @RequestParam("matricula") String matricula,
                         @RequestParam(value = "idTurma", required = false) Long idTurma) {
        Turma turma = null;
        if(idTurma != null) {
            turma = turmaRepository.findById(idTurma).get();
        }
        Aluno aluno = new Aluno();
        aluno.setTurma(turma);
        aluno.setMatricula(matricula);
        aluno.setNome(nome);
        alunoRepository.save(aluno);
        return "redirect:/aluno/list";

    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Aluno> all = alunoRepository.findAll();
        model.put("alunoList", all);
        return "aluno/list";
    }



}
