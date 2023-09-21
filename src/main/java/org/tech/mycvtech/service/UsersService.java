package org.tech.mycvtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tech.mycvtech.model.Admin;
import org.tech.mycvtech.model.Student;
import org.tech.mycvtech.model.User;
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
        return mongoRepository.findById(userId).get();
    }

    public void deleteUserById(String userID) {
        mongoRepository.deleteById(userID);
    }

    // Students
    public Student addStudent(Student newStudent) {
        System.out.println(newStudent);
        return mongoRepository.save(newStudent);
    }

    public Student updateStudent(Student studentUpdates, String studentId) {
        Student studentExist = (Student) findUserById(studentId);
        studentExist.update(studentUpdates);
        return mongoRepository.save(studentExist);
    }

    // Admins
    public Admin addAdmin(Admin newAdmin) {
        return mongoRepository.save(newAdmin);
    }

    public Admin updateAdmin(Admin adminUpdates, String adminId) {
        Admin adminExist = (Admin) findUserById(adminId);
        adminExist.update(adminUpdates);
        return mongoRepository.save(adminUpdates);
    }
}
