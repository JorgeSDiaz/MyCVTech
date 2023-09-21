package org.tech.mycvtech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    String academicProgram;
    String semester;
    String interestedArea;
    List<SoftSkill> softSkills;
    List<Knowledge> expertise;

    public Student() {
        this.rol = new Rol("STUDENT");
        this.softSkills = softSkills != null ? softSkills : new ArrayList<SoftSkill>();
        this.expertise = expertise != null ? expertise : new ArrayList<Knowledge>();
    }

    public String getAcademicProgram() {
        return academicProgram;
    }

    public void setAcademicProgram(String academicProgram) {
        this.academicProgram = academicProgram;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getInterestedArea() {
        return interestedArea;
    }

    public void setInterestedArea(String interestedArea) {
        this.interestedArea = interestedArea;
    }

    public List<SoftSkill> getSoftSkills() {
        return softSkills;
    }

    public void addSoftSkill(SoftSkill softSkill) {
        this.softSkills.add(softSkill);
    }

    public List<Knowledge> getExpertise() {
        return expertise;
    }

    public void addKnowledge(Knowledge knowledge) {
        this.expertise.add(knowledge);
    }
}
