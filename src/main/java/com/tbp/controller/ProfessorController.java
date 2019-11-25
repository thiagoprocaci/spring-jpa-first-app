package com.tbp.controller;

import com.tbp.model.Professor;
import com.tbp.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("professor")
public class ProfessorController {


    @Autowired
    ProfessorRepository professorRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Professor>  findAll() {
        Iterable<Professor> all = professorRepository.findAll();
        return all;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Professor save(@RequestBody Professor professor) {
        Professor p = professorRepository.save(professor);
        return p;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Professor update(@RequestBody Professor professor) {
        Professor p = professorRepository.save(professor);
        return p;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(@RequestBody Professor professor) {
        professorRepository.delete(professor.getId());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Professor getById(@PathVariable Long id) {
        Professor professor = professorRepository.findOne(id);
        return professor;
    }


}
