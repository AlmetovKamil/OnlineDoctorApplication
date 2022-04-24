package org.onlinedoctorapplication.staff;

import org.onlinedoctorapplication.Patient;

public abstract class Doctor {
    protected String fullName;
    protected String speciality;
    protected Integer salary = 40000;
    private String timeTable = "MO - FR from 10AM to 5PM";

    public Doctor(String fullName) {
        this.fullName = fullName;
    }

    public String answerPatientQuestion(Patient patient, String question) {
        return "Doctor: Good question.";
    }

    public String getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(String timeTable) {
        this.timeTable = timeTable;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpeciality() {
        return speciality;
    }
}
