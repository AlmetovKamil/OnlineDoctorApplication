package org.onlinedoctorapplication;

import org.onlinedoctorapplication.diagnoses.Healthy;
import org.onlinedoctorapplication.diagnoses.Diagnosis;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.List;

public class OnlineDoctorApplication {
    private Diagnosis state;
    private Patient patient;
    private IDialog dialog;
    private static List<Doctor> doctors; // Доктор не поможет

    public OnlineDoctorApplication(Patient patient, IDialog dialog) {
        this.state = new Healthy();
        this.state.setApplication(this);
        this.patient = patient;
        this.dialog = dialog;
    }

    public void changeDiagnosis(Diagnosis state) {
        this.state = state;
    }

    public void showDiagnosis() {
        state.printMe(dialog);
    }

    public void defineSymptoms() {
        boolean haveMoreSymptoms = true;
        while (haveMoreSymptoms)
            haveMoreSymptoms = state.nextDiagnosis(dialog);
        showDiagnosis();
        patient.setLastDiagnosis(state);
        dialog.printInformation(state.printDoctors());
    }

    public void bookingDoctor(){
        dialog.printInformation("Choose the doctor for booking (write the number) : ");
        int j = Integer.parseInt(dialog.optionList(patient.getLastDiagnosis().printDoctors())) - 1;
        dialog.printInformation("You booked " + patient.getLastDiagnosis().getDoctors().get(j).getFullName() + " in 10AM.");
    }

    public void discussionWithDoctor(){
        dialog.printInformation("Choose the doctor for conversation (write the number) : ");
        int j = Integer.parseInt(dialog.optionList(patient.getLastDiagnosis().printDoctors())) - 1;
        dialog.askQuestion(patient, patient.getLastDiagnosis().getDoctors().get(j));
    }
}
