package com.tbp.controller;

import com.tbp.model.Hobby;
import com.tbp.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hobby")
public class HobbyController {

    @Autowired
    HobbyRepository hobbyRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Hobby> findAll() {
        return hobbyRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Hobby save(@RequestBody Hobby hobby) {
        Hobby savedHobby = hobbyRepository.save(hobby);
        return savedHobby;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Hobby update(@RequestBody Hobby hobby) {
        Hobby savedHobby = hobbyRepository.save(hobby);
        return savedHobby;
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(@RequestBody Hobby hobby) {
        hobbyRepository.delete(hobby.getId());
    }


}
