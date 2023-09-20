package org.tech.mycvtech.model;

public class Admin extends User {
    public String accessLevel;
    public String department;

    public Admin(
            Long id,
            String username,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            String rol,
            String accessLevel,
            String department
    ) {
        super(id, username, firstName, lastName, email, phone, password, rol);
        this.accessLevel = accessLevel;
        this.department = department;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
