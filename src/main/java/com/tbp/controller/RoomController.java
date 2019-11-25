package com.tbp.controller;

import com.tbp.model.Room;
import com.tbp.model.Student;
import com.tbp.repository.ProfessorRepository;
import com.tbp.repository.RoomRepository;
import com.tbp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Room>  findAll() {
        Iterable<Room> all = roomRepository.findAll();
        return all;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Room save(@RequestBody Room room) {
        return saveOrUpdate(room);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Room update(@RequestBody Room room) {
        List<Student> studentsByRoom = studentRepository.findByRoom(room);
        for(Student s: studentsByRoom) {
            s.setRoom(null);
            studentRepository.save(s);
        }
        return saveOrUpdate(room);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(@RequestBody Room room) {
        roomRepository.delete(room.getId());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Room getById(@PathVariable Long id) {
        Room room = roomRepository.findOne(id);
        return room;
    }

    private Room saveOrUpdate(Room room) {
        List<Student> studentList = room.getStudentList();
        room.setStudentList(null);
        Room p = roomRepository.save(room);
        for(Student student : studentList) {
            student = studentRepository.findOne(student.getId());
            student.setRoom(p);
            studentRepository.save(student);
        }
        return roomRepository.findOne(room.getId());
    }

}
