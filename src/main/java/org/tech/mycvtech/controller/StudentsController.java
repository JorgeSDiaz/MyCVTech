package org.tech.mycvtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tech.mycvtech.service.StudentService;

@RestController
@RequestMapping("/v1/students")
public class StudentsController {
    private final StudentService service;

    @Autowired
    public StudentsController(StudentService studentsService) {
        this.service = studentsService;
    }
}
