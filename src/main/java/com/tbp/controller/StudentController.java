package com.tbp.controller;

import com.tbp.model.Student;
import com.tbp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Student>  findAll() {
        Iterable<Student> all = studentRepository.findAll();
        return all;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        Student p = studentRepository.save(student);
        return p;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Student update(@RequestBody Student student) {
        Student p = studentRepository.save(student);
        return p;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(@RequestBody Student student) {
        studentRepository.delete(student.getId());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student getById(@PathVariable Long id) {
        Student student = studentRepository.findOne(id);
        return student;
    }

}
