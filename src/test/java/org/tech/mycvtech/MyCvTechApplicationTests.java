package org.tech.mycvtech;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.tech.mycvtech.controller.user.UsersController;
import org.tech.mycvtech.model.user.Admin;
import org.tech.mycvtech.model.user.Student;
import org.tech.mycvtech.model.user.User;
import org.tech.mycvtech.service.user.UsersService;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.List;
@SpringBootTest
class MyCvTechApplicationTests {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private UsersService usersService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(usersController).build();
    }
    /**
     * Prueba unitaria para verificar que el método getAllUsers() del controlador
     * devuelve una lista de usuarios y tiene una respuesta HTTP OK.
     */
    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(), new User());
        when(usersService.allUsers()).thenReturn(users);
        ResponseEntity<List<User>> response = usersController.getAllUsers();
        verify(usersService, times(1)).allUsers();
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == users;
    }
    /**
     * Prueba unitaria para verificar que el método getUserByID() del controlador
     * devuelve un usuario y tiene una respuesta HTTP OK.
     */
    @Test
    public void testGetUserByID() {

        User user = new User();
        when(usersService.findUserById(anyString())).thenReturn(user);
        ResponseEntity<User> response = usersController.getUserByID("1");
        verify(usersService, times(1)).findUserById("1");
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == user;
    }

        /**
     * Prueba unitaria para verificar que el método deleteUsers() del controlador
     * elimina un usuario y devuelve una respuesta HTTP OK.
     */

    @Test
    public void testDeleteUser() {
        ResponseEntity<?> response = usersController.deleteUsers("1");
        verify(usersService, times(1)).deleteUserById("1");
        assert response.getStatusCode() == HttpStatus.OK;
    }
    /**
     * Prueba unitaria para verificar que el método addStudent() del controlador
     * agrega un estudiante y devuelve una respuesta HTTP OK.
     */
    @Test
    public void testAddStudent() {
        Student student = new Student();
        when(usersService.addStudent(any(Student.class))).thenReturn(student);
        ResponseEntity<Student> response = usersController.addStudent(new Student());
        verify(usersService, times(1)).addStudent(any(Student.class));
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == student;
    }
    /**
     * Prueba unitaria para verificar que el método updateStudent() del controlador
     * actualiza un estudiante y devuelve una respuesta HTTP OK.
     */
    @Test
    public void testUpdateStudent() {
        // Mock de un estudiante actualizado
        Student updatedStudent = new Student();
        when(usersService.updateStudent(any(Student.class), anyString())).thenReturn(updatedStudent);
        ResponseEntity<Student> response = usersController.updateStudent(new Student(), "1");
        verify(usersService, times(1)).updateStudent(any(Student.class), eq("1"));
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == updatedStudent;
    }
    /**
     * Prueba unitaria para verificar que el método updateStudent() del controlador
     * actualiza un estudiante y devuelve una respuesta HTTP OK.
     */
    @Test
    public void testAddAdmin() {
        Admin admin = new Admin();
        when(usersService.addAdmin(any(Admin.class))).thenReturn(admin);
        ResponseEntity<Admin> response = usersController.addAdmin(new Admin());
        verify(usersService, times(1)).addAdmin(any(Admin.class));
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == admin;
    }
    /**
     * Prueba unitaria para verificar que el método addAdmin() del controlador
     * agrega un administrador y devuelve una respuesta HTTP OK.
     */
    @Test
    public void testUpdateAdmin() {
        Admin updatedAdmin = new Admin();
        when(usersService.updateAdmin(any(Admin.class), anyString())).thenReturn(updatedAdmin);
        ResponseEntity<Admin> response = usersController.updateAdmin(new Admin(), "1");
        verify(usersService, times(1)).updateAdmin(any(Admin.class), eq("1"));
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == updatedAdmin;
    }
}

