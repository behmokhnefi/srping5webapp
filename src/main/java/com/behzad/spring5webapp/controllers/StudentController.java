package com.behzad.spring5webapp.controllers;

import com.behzad.spring5webapp.model.Guid;
import com.behzad.spring5webapp.model.Student;
import com.behzad.spring5webapp.repositories.GuidRepository;
import com.behzad.spring5webapp.repositories.StrudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    GuidRepository guidRepository;

    @Autowired
    StrudentRepository strudentRepository;

    @GetMapping("/add")
    public String add(){
        Guid guid = new Guid();
        guid.setGuidDescription("salaaaaaam");

        Student student  = new Student();
        student.setFamily("mokhnefi");
        student.setName("behzad");
        student.setGuid(guid);

        Student student2  = new Student();
        student2.setFamily("mokhnefi2");
        student2.setName("behzad2");
        student2.setGuid(guid);

        guid.getStudents().add(student);
        guid.getStudents().add(student2);

        guidRepository.save(guid);
//        strudentRepository.save(student);
//        strudentRepository.save(student2);

        return guidRepository.findAll().toString();

    }
    @GetMapping("update")
    public String update(){
        Optional<Guid> guid= guidRepository.findById(1L);
        Student student = new Student("behrooz","sos");
        student.setGuid(guid.get());
        guid.get().getStudents().add(student);
        guidRepository.save(guid.get());
        return guid.get().toString();
    }


}
