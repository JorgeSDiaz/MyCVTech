package org.tech.mycvtech.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    String academicProgram;
    String semester;
    String interestedArea;
    List<SoftSkill> softSkills;
    List<Knowledge> expertise;

    public Student(
            String id,
            String username,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            String academicProgram,
            String semester,
            String interestedArea,
            List<SoftSkill> softSkills,
            List<Knowledge> expertise
    ) {
        super(id, username, firstName, lastName, email, password, phone, "STUDENT");
        this.academicProgram = academicProgram;
        this.semester = semester;
        this.interestedArea = interestedArea;
        System.out.println(softSkills);
        this.softSkills = softSkills != null ? softSkills : new ArrayList<SoftSkill>();
        this.expertise = expertise != null ? expertise : new ArrayList<Knowledge>();
    }

    public Student() {
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

    public List<SoftSkill> getSkills() {
        return softSkills;
    }

    public void addSkill(SoftSkill softSkill) {
        this.softSkills.add(softSkill);
    }

    public List<Knowledge> getExpertise() {
        return expertise;
    }

    public void addKnowledge(Knowledge knowledge) {
        this.expertise.add(knowledge);
    }
}
