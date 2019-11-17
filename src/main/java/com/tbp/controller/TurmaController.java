package com.tbp.controller;

import com.tbp.model.Turma;
import com.tbp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    TurmaRepository turmaRepository;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "turma/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@RequestParam("descricao") String descricao) {
        Turma turma = new Turma();
        turma.setDescricao(descricao);
        turmaRepository.save(turma);
        return "redirect:/turma/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Turma> all = turmaRepository.findAll();
        model.put("turmaList", all);
        return "turma/list";
    }


}
