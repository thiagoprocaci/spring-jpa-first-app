package com.tbp.controller;

import com.tbp.model.Disciplina;
import com.tbp.model.Turma;
import com.tbp.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "disciplina/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@RequestParam("nome") String nome) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        disciplinaRepository.save(disciplina);
        return "redirect:/disciplina/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Disciplina> all = disciplinaRepository.findAll();
        model.put("disciplinaList", all);
        return "disciplina/list";
    }

}
