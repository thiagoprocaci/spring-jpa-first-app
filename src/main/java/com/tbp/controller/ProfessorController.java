package com.tbp.controller;

import com.tbp.model.Disciplina;
import com.tbp.model.Professor;
import com.tbp.repository.DisciplinaRepository;
import com.tbp.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    DisciplinaRepository disciplinaRepository;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(Map<String, Object> model) {

        return "professor/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam("nome") String nome,
                         @RequestParam("formacao") String formacao,
                         @RequestParam(value = "idDisciplinas", required = false) Long[] idDisciplinas) {

        return "redirect:/professor/list";
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {

        return "professor/list";
    }

}
