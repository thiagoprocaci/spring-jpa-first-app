package com.tbp.controller;

import com.tbp.model.Hobby;
import com.tbp.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
public class HobbyController {

    @Autowired
    HobbyRepository hobbyRepository;

    @RequestMapping(value = "hobby/create", method = RequestMethod.GET)
    public String createPage() {
        return "hobby/create";
    }

    @RequestMapping(value = "hobby/list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Hobby> all = hobbyRepository.findAll();
        model.put("hobbyList", all);
        return "hobby/list";
    }

    @RequestMapping(value = "hobby/edit", method = RequestMethod.GET)
    public String editPage(@Param("id") Long id, Map<String, Object> model) {
        Hobby hobby = hobbyRepository.findOne(id);
        model.put("hobby", hobby);
        return "hobby/edit";

    }

    @RequestMapping(value = "/hobby/create", method = RequestMethod.POST)
    public void create(@Param("name") String name, Map<String, Object> model) {
        Hobby hobby = new Hobby();
        hobby.setName(name);
        hobbyRepository.save(hobby);
        model.put("message", "Hobby " + name + " created");
    }

    @RequestMapping(value = "/hobby/edit", method = RequestMethod.POST)
    public void update(@Param("name") String name, @Param("id") Long id, Map<String, Object> model) {
        Hobby hobby = hobbyRepository.findOne(id);
        hobby.setName(name);
        hobbyRepository.save(hobby);
        model.put("message", "Hobby " + name + " edited");
    }


}
