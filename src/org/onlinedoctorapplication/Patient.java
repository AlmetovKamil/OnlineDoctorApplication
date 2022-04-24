package org.onlinedoctorapplication;

import org.onlinedoctorapplication.diagnoses.Diagnosis;
import org.onlinedoctorapplication.diagnoses.Healthy;

public class Patient {
    private String name;
    private String surname;
    private int age;
    private Diagnosis lastDiagnosis;

    public Patient(String surname, String name, int age) throws Exception {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Diagnosis getLastDiagnosis() {
        return lastDiagnosis;
    }

    public void setLastDiagnosis(Diagnosis lastDiagnosis) {
        this.lastDiagnosis = lastDiagnosis;
    }
}
