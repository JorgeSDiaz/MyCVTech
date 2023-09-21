package org.tech.mycvtech.model;

public class Admin extends User {
    public String accessLevel;
    public String department;

    public Admin() {
        if (this.accessLevel == null) {
            this.accessLevel = "1";
        }

        if (this.department == null) {
            this.department = "Unknown";
        }

        this.rol = new Rol("ADMIN");
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
