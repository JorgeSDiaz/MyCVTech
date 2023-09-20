package org.tech.mycvtech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Date createdAt;
    private Rol rol;

    public User(
            Long id,
            String username,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            String rol
    ) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.rol = new Rol(rol);
        this.password = new BCryptPasswordEncoder().encode(password);
        this.createdAt = new Date();
    }

    public User() {
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Rol getRol() {
        return rol;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    protected void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
