package org.onlinedoctorapplication.staff;

import org.onlinedoctorapplication.Patient;

public abstract class Doctor {
    protected String fullName;
    public String answerPatientQuestion(Patient patient, String question) {
        return "Doctor: Good question.";
    }

    private String timeTable = "MO - FR from 10AM to 5PM";

    public String getTimeTable() {
        return timeTable;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTimeTable(String timeTable) {
        this.timeTable = timeTable;
    }

    public Doctor(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
