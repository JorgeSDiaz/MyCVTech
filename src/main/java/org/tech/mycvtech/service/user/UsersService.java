package org.tech.mycvtech.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.tech.mycvtech.model.user.Admin;
import org.tech.mycvtech.model.user.Student;
import org.tech.mycvtech.model.user.User;
import org.tech.mycvtech.repository.UserMongoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UserMongoRepository mongoRepository;

    @Autowired
    public UsersService(UserMongoRepository userMongoRepository) {
        this.mongoRepository = userMongoRepository;
    }

    // Users
    public List<User> allUsers() {
        return mongoRepository.findAll();
    }

    public User findUserById(String userId) {
        Optional<User> existedUser = this.mongoRepository.findById(userId);
        if (existedUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + userId + " not found");
        }
        return existedUser.get();
    }

    public void deleteUserById(String userId) {
        Optional<User> existedUser = this.mongoRepository.findById(userId);
        if (existedUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + userId + " not found");
        }
        mongoRepository.deleteById(userId);
    }

    // Students
    public Student addStudent(Student newStudent) {
        Optional<User> existedUser = this.mongoRepository.findUserByEmail(newStudent.getEmail());
        if (existedUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with email: " + newStudent + " already exist");
        }
        return mongoRepository.save(newStudent);
    }

    public Student updateStudent(Student studentUpdates, String studentId) {
        Student studentExist = (Student) findUserById(studentId);
        studentExist.update(studentUpdates);
        return mongoRepository.save(studentExist);
    }

    // Admins
    public Admin addAdmin(Admin newAdmin) {
        Optional<User> existedAdmin = this.mongoRepository.findUserByEmail(newAdmin.getEmail());
        if (existedAdmin.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Admin with email: "  + newAdmin.getEmail() + " already exist");
        }
        return mongoRepository.save(newAdmin);
    }

    public Admin updateAdmin(Admin adminUpdates, String adminId) {
        Admin adminExist = (Admin) findUserById(adminId);
        adminExist.update(adminUpdates);
        return mongoRepository.save(adminUpdates);
    }
}
