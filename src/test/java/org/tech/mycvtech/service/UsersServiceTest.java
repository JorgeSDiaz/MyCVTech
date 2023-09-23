package org.tech.mycvtech.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.tech.mycvtech.model.user.Admin;
import org.tech.mycvtech.model.user.Student;
import org.tech.mycvtech.model.user.User;
import org.tech.mycvtech.repository.UserMongoRepository;
import org.tech.mycvtech.service.user.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UsersServiceTest {

    @InjectMocks
    private UsersService usersService;

    @Mock
    private UserMongoRepository mongoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAllUsers() {

        List<User> userList = new ArrayList<>();
        userList.add(new Student());
        userList.add(new Admin());
        Mockito.when(mongoRepository.findAll()).thenReturn(userList);


        List<User> result = usersService.allUsers();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindUserById() {

        String userId = "user123";
        User user = new Student();
        user.setId(userId);
        Mockito.when(mongoRepository.findById(userId)).thenReturn(Optional.of(user));


        User result = usersService.findUserById(userId);
        assertEquals(userId, result.getId());
    }

    @Test
    public void testDeleteUserById() {

        String userId = "user123";
        Mockito.doNothing().when(mongoRepository).deleteById(userId);


        assertDoesNotThrow(() -> usersService.deleteUserById(userId));
    }

    @Test
    public void testAddStudent() {

        Student newStudent = new Student();
        Mockito.when(mongoRepository.save(newStudent)).thenReturn(newStudent);


        Student result = usersService.addStudent(newStudent);
        assertEquals(newStudent, result);
    }


}
