package org.tech.mycvtech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Document("Users")
public class User {
    @Id
    protected String id;
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String phone;
    protected Date createdAt;
    protected Rol rol;

    public User() {
        this.createdAt = new Date();
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
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
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    protected void update(User userUpdates) {

        if (userUpdates.getUsername() != null) {
            setUsername(userUpdates.getUsername());
        }

        if (userUpdates.getFirstName() != null) {
            setFirstName(userUpdates.getFirstName());
        }

        if (userUpdates.getLastName() != null) {
            setLastName(userUpdates.getLastName());
        }

        if (userUpdates.getEmail() != null) {
            setEmail(userUpdates.getEmail());
        }

        if (userUpdates.getPassword() != null) {
            setPassword(userUpdates.getPassword());
        }
    }
}
