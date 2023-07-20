package com.bergony.demo.rest;

import com.bergony.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        theStudents.add(new Student("Berony", "bandeira"));
        theStudents.add(new Student("Jessica", "bandeira"));
        theStudents.add(new Student("Thrall", "bandeira"));
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
    @GetMapping("/students/{studendtId}")
    public Student getStudents(@PathVariable("studendtId") int studendtId) {

        if(studendtId >= theStudents.size() || studendtId < 0)
            throw new StudentNotFoundException("Student id not found - "+ studendtId);

        return theStudents.get(studendtId);
    }


}
