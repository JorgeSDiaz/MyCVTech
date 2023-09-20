package org.tech.mycvtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tech.mycvtech.service.UsersService;

@RestController
@RequestMapping("/v1/students")
public class UsersController {
    private final UsersService service;

    @Autowired
    public UsersController(UsersService studentsService) {
        this.service = studentsService;
    }

}
