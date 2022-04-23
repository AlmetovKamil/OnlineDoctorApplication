package org.onlinedoctorapplication.staff;

import org.onlinedoctorapplication.Patient;

import java.awt.*;

public class Admin {
    public void ChangeTimeTable(Doctor doctor, String newTime) {
        doctor.setTimeTable(newTime);
    }

    public String GetPatientInformation(Patient patient) {
        String info = "Name:" + patient.getName() + " Surname: " + patient.getSurname();
        if(patient.getLastDiagnosis() != null) {
            info += "Diagnosis: " + patient.getLastDiagnosis().getName();
        }
        return info;
    }
}
