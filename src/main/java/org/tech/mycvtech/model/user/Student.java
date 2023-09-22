package org.tech.mycvtech.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.tech.mycvtech.model.util.Knowledge;
import org.tech.mycvtech.model.util.Rol;
import org.tech.mycvtech.model.util.SoftSkill;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Student extends User {
    String academicProgram;
    String semester;
    String interestedArea;
    List<SoftSkill> softSkills;
    List<Knowledge> expertise;

    public Student() {
        this.rol = Rol.USER;
        this.softSkills = softSkills != null ? softSkills : new ArrayList<>();
        this.expertise = expertise != null ? expertise : new ArrayList<>();
    }

    public void addSoftSkill(SoftSkill softSkill) {
        this.softSkills.add(softSkill);
    }

    public void addKnowledge(Knowledge knowledge) {
        this.expertise.add(knowledge);
    }

    public void update(Student studentUpdates) {
        super.update(studentUpdates);

        if (studentUpdates.getAcademicProgram() != null) {
            setAcademicProgram(studentUpdates.getAcademicProgram());
        }

        if (studentUpdates.getSemester() != null) {
            setSemester(studentUpdates.getSemester());
        }

        if (studentUpdates.getInterestedArea() != null) {
            setInterestedArea(studentUpdates.getInterestedArea());
        }

    }
}
