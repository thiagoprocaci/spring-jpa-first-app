package com.tbp.controller;

import com.tbp.model.Person;

import com.tbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Person>  findAll() {
        Iterable<Person> all = personRepository.findAll();
        return all;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person save(@RequestBody Person person) {
        Person p = personRepository.save(person);
        return p;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Person update(@RequestBody Person person) {
       Person p = personRepository.save(person);
       return p;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(@RequestBody Person person) {
        personRepository.delete(person.getId());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Person getById(@PathVariable Long id) {
        Person person = personRepository.findOne(id);
        return person;
    }
}
