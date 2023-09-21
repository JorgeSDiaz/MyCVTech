package org.tech.mycvtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tech.mycvtech.model.Admin;
import org.tech.mycvtech.model.Student;
import org.tech.mycvtech.model.User;
import org.tech.mycvtech.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UsersController {
    private final UsersService service;

    @Autowired
    public UsersController(UsersService studentsService) {
        this.service = studentsService;
    }

    // Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(this.service.allUsers(), HttpStatus.OK);
    }

    // Students
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student newStudent) {
        return new ResponseEntity<Student>(this.service.addStudent(newStudent), HttpStatus.OK);
    }

    // Admins
    @PostMapping("/admins")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin newAdmin) {
        return new ResponseEntity<Admin>(this.service.addAdmin(newAdmin), HttpStatus.OK);
    }
}
