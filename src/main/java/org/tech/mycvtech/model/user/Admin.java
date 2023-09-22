package org.tech.mycvtech.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.tech.mycvtech.model.util.Rol;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
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

        this.rol = Rol.ADMIN;
    }

    public void update(Admin adminUpdates) {
        super.update(adminUpdates);

        if (adminUpdates.getAccessLevel() != null) {
            setAccessLevel(adminUpdates.getAccessLevel());
        }
    }
}
