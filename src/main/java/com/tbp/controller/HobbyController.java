package com.tbp.controller;

import com.tbp.model.Hobby;
import com.tbp.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbyController {

    @Autowired
    HobbyRepository hobbyRepository;

    @RequestMapping(value = "/hobby/all", method = RequestMethod.GET)
    public Iterable<Hobby> findAll() {
        return hobbyRepository.findAll();
    }

    @RequestMapping(value = "/hobby/save", method = RequestMethod.GET)
    public Hobby save(@Param("name") String name) {
        Hobby hobby = new Hobby();
        hobby.setName(name);
        Hobby savedHobby = hobbyRepository.save(hobby);
        return savedHobby;
    }

    @RequestMapping(value = "/hobby/update", method = RequestMethod.GET)
    public Hobby update(@Param("name") String name, @Param("id") Long id) {
        Hobby hobby = hobbyRepository.findOne(id);
        hobby.setName(name);
        Hobby savedHobby = hobbyRepository.save(hobby);
        return savedHobby;

    }


}
