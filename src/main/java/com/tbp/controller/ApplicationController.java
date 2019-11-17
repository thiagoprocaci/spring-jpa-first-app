package com.tbp.controller;

import com.tbp.model.Aluno;
import com.tbp.model.Disciplina;
import com.tbp.model.Professor;
import com.tbp.model.Turma;
import com.tbp.repository.AlunoRepository;
import com.tbp.repository.DisciplinaRepository;
import com.tbp.repository.ProfessorRepository;
import com.tbp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    DisciplinaRepository disciplinaRepository;

    @RequestMapping(value = "turma/salvar", method = RequestMethod.GET)
    public Turma salvarTurma(@RequestParam("descricao") String descricao) {
        Turma turma = new Turma();
        turma.setDescricao(descricao);
        turma = turmaRepository.save(turma);
        return turma;
    }

    @RequestMapping(value = "aluno/salvar", method = RequestMethod.GET)
    public Aluno salvarAluno(@RequestParam("nome") String nome,
                              @RequestParam("matricula") String matricula,
                             @RequestParam(value = "turmaId", required = false) Long turmaId) {
        Turma turma = null;
        if(turmaId != null) {
            turma = turmaRepository.findOne(turmaId);
        }
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setTurma(turma);
        aluno = alunoRepository.save(aluno);
        return aluno;
    }


    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String salvar() {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Java Web");
        disciplina = disciplinaRepository.save(disciplina);

        Professor professor = new Professor();
        professor.setNome("Thiago");
        professor.setFormacao("Informatica");
        professor.getDisciplinas().add(disciplina);

        professor = professorRepository.save(professor);
        return "salvo";
    }







}
