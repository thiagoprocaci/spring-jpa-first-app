package com.tbp.controller;

import com.tbp.model.Alocacao;
import com.tbp.model.Disciplina;
import com.tbp.model.Professor;
import com.tbp.model.Turma;
import com.tbp.repository.AlocacaoRepository;
import com.tbp.repository.DisciplinaRepository;
import com.tbp.repository.ProfessorRepository;
import com.tbp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("alocacao")
public class AlocacaoController {

    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    AlocacaoRepository alocacaoRepository;
    @Autowired
    DisciplinaRepository disciplinaRepository;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(Map<String, Object> model) {
        Iterable<Professor> professorList = professorRepository.findAll();
        Iterable<Turma> turmaList = turmaRepository.findAll();
        Iterable<Disciplina> disciplinaList = disciplinaRepository.findAll();
        model.put("professorList", professorList);
        model.put("turmaList", turmaList);
        model.put("disciplinaList", disciplinaList);
        return "alocacao/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam("idTurma") Long idTurma,
                         @RequestParam("idProfessor") Long idProfessor,
                         @RequestParam("idDisciplina") Long idDisciplina,
                         @RequestParam("horario") String horario
                         ) {
        Turma turma = turmaRepository.findById(idTurma).get();
        Professor professor = professorRepository.findById(idProfessor).get();
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina).get();
        Alocacao alocacao = new Alocacao();
        alocacao.setHorario(horario);
        alocacao.setProfessor(professor);
        alocacao.setTurma(turma);
        alocacao.setDisciplina(disciplina);
        alocacaoRepository.save(alocacao);
        return "redirect:/professor/list";
    }


}
