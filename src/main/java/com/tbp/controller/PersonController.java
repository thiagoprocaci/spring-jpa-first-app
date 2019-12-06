package com.tbp.controller;

import com.tbp.model.Hobby;
import com.tbp.model.Person;
import com.tbp.repository.HobbyRepository;
import com.tbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    HobbyRepository hobbyRepository;


    @RequestMapping(value = "/person/create", method = RequestMethod.GET)
    public String createPage(Map<String, Object> model) {
        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        return "person/create";
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.POST)
    public void save(@RequestParam("name") String name,
                     @RequestParam("age") Integer age,
                     @RequestParam(value = "idHobby", required = false) Long idHobby,
                     @RequestParam("username") String username,
                     @RequestParam("password") String password,
                     Map<String, Object> model) {
        Hobby hobby = null;
        if(idHobby != null) {
            hobby = hobbyRepository.findOne(idHobby);
        }

        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setFavoriteHobby(hobby);
        person.setPassword(password);
        person.setUsername(username);
        personRepository.save(person);

        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        model.put("message", "Person " + name + " created");
    }


    @RequestMapping(value = "/person/list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Person> personList = personRepository.findAll();
        model.put("personList", personList);
        return "person/list";
    }

    @RequestMapping(value = "/person/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam("id") Long id, Map<String, Object> model) {
        Person person = personRepository.findOne(id);
        model.put("person", person);

        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        return "person/edit";
    }


    @RequestMapping(value = "/person/edit", method = RequestMethod.POST)
    public void update(@RequestParam("name") String name, @RequestParam("age") Integer age,
                         @RequestParam("idPerson") Long idPerson, @RequestParam("idHobby") Long idHobby,
                       Map<String, Object> model) {
        Hobby hobby = hobbyRepository.findOne(idHobby);
        Person person = personRepository.findOne(idPerson);
        person.setName(name);
        person.setAge(age);
        person.setFavoriteHobby(hobby);
        personRepository.save(person);


        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        model.put("person", person);
        model.put("message", "Person " + name + " edited");
    }

    @RequestMapping(value = "person/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id) {
        personRepository.delete(id);
        return "redirect:/person/list";
    }

}
