package org.tech.mycvtech.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.tech.mycvtech.model.util.Rol;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document("Users")
@Builder
@Data
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    protected String id;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    protected void update(User userUpdates) {

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
