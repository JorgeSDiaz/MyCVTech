package org.tech.mycvtech.controller.user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tech.mycvtech.model.user.Admin;
import org.tech.mycvtech.model.user.Student;
import org.tech.mycvtech.model.user.User;
import org.tech.mycvtech.service.user.UsersService;

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

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") String userId) {
        return new ResponseEntity<User>(this.service.findUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable("id") String userId) {
        this.service.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Students
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student newStudent) {
        return new ResponseEntity<Student>(this.service.addStudent(newStudent), HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(
            @RequestBody Student studentUpdates,
            @PathVariable("id") String studentId
    ) {
        return new ResponseEntity<Student>(this.service.updateStudent(studentUpdates, studentId), HttpStatus.OK);
    }

    // Admins
    @PostMapping("/admins")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin newAdmin) {
        return new ResponseEntity<Admin>(this.service.addAdmin(newAdmin), HttpStatus.OK);
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(
            @RequestBody Admin adminUpdates,
            @PathVariable("id") String adminId
    ) {
        return new ResponseEntity<>(this.service.updateAdmin(adminUpdates, adminId) ,HttpStatus.OK);
    }
}
