package org.tech.mycvtech.model;

public class Admin extends User {
    public String accessLevel;
    public String department;

    public Admin(
            String id,
            String username,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            String accessLevel,
            String department
    ) {
        super(id, username, firstName, lastName, email, phone, password, "ADMIN");
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
