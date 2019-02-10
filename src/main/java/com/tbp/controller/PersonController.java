package com.tbp.controller;

import com.tbp.model.Hobby;
import com.tbp.model.Person;
import com.tbp.repository.HobbyRepository;
import com.tbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    HobbyRepository hobbyRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Person index() {
        Person person = new Person();
        person.setName("John");
        person.setAge(12);
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }
    
    @RequestMapping(value = "/person/all", method = RequestMethod.GET)
    public Iterable<Person>  findAll() {
        Iterable<Person> all = personRepository.findAll();
        return all;
    }

    @RequestMapping(value = "/person/save", method = RequestMethod.GET)
    public Person save(@Param("name") String name, @Param("age") Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personRepository.save(person);
        return person;
    }

    @RequestMapping(value = "/person/update", method = RequestMethod.GET)
    public Person update(@Param("name") String name, @Param("age") Integer age, @Param("id") Long id) {
        Person person = personRepository.findOne(id);
        person.setName(name);
        person.setAge(age);
        personRepository.save(person);
        return person;
    }

    @RequestMapping(value = "/person/remove", method = RequestMethod.GET)
    public String remove(@Param("id") Long id) {
        personRepository.delete(id);
        return "Person with id = " + id + " removed";
    }

    @RequestMapping(value = "/person/addHobby", method = RequestMethod.GET)
    public Person addHobby(@Param("idPerson") Long idPerson, @Param("idHobby") Long idHobby) {
        Hobby hobby = hobbyRepository.findOne(idHobby);
        Person person = personRepository.findOne(idPerson);
        person.setFavoriteHobby(hobby);
        return personRepository.save(person);
    }


}
