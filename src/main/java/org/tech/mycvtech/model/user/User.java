package org.tech.mycvtech.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.tech.mycvtech.model.util.Rol;

import java.util.Date;

@Document("Users")
@Builder
@Data
@AllArgsConstructor
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

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
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
