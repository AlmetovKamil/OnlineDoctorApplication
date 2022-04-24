package org.onlinedoctorapplication;

import org.onlinedoctorapplication.diagnoses.*;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.*;

import java.util.ArrayList;
import java.util.HashMap;

public class OnlineDoctorApplication {
    private Diagnosis state;
    private Patient patient;
    private IDialog dialog;
    private final ArrayList<String> symptoms;
    private final HashMap<String, Diagnosis> diagnosisHashMap;
    private final HashMap<String, Doctor> doctors;
    private final HashMap<Doctor, Diagnosis> doctorDiagnosisHashMap;

    public OnlineDoctorApplication(Patient patient, IDialog dialog) throws Exception {
        this.diagnosisHashMap = new HashMap<>(16){{
            put("Flu", new Flu());
            put("Allergy", new Allergy());
            put("Bronchitis", new Bronchitis());
            put("Healthy", new Healthy());
            put("ICP", new ICP());
            put("Migraine", new Migraine());
            put("SARS", new SARS());
            put("Sinusitis", new Sinusitis());
        }};
        this.doctors = new HashMap<>(16){{
            put("Nikita Kudasov", new Therapist("Nikita Kudasov"));
            put("Vladimir Zouev", new Allergoloc("Vladimir Zouev"));
            put("Andrey Holodov", new Neurologist("Andrey Holodov"));
            put("Mikhail Gorodetskiy", new Therapist("Mikhail Gorodetskiy"));
            put("Surabh Pall", new Otolaryngologist("Surabh Pall"));
            put("Adil Khan", new Therapist("Adil Khan"));
            put("Sergey Ivanov", new Therapist("Sergey Ivanov"));
            put("Muwaffaq Imam", new Neurologist("Muwaffaq Imam"));
        }};
        this.doctorDiagnosisHashMap = new HashMap<>(16);
        this.state = this.diagnosisHashMap.get("Healthy");
        this.state.setApplication(this);
        this.state.initializeDoctorsAndTransitions();
        this.patient = patient;
        this.patient.setLastDiagnosis(this.state);
        this.dialog = dialog;
        this.symptoms = new ArrayList<>(){{
            add("Cough");
            add("Headache");
            add("Sneezing");
        }};
    }

    public void changeDiagnosis(Diagnosis state) {
        this.state = state;
    }

    public void showDiagnosis() {
        state.printMe(dialog);
    }

    public void defineSymptoms() throws Exception {
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

    public boolean hasSymptom(String symptom){
        return symptoms.contains(symptom);
    }

    public boolean hasDiagnosis(String diagnosis){
        return diagnosisHashMap.containsKey(diagnosis);
    }

    public HashMap<String, Doctor> getDoctors() {
        return doctors;
    }

    public HashMap<String, Diagnosis> getDiagnosisHashMap() {
        return diagnosisHashMap;
    }

    public HashMap<Doctor, Diagnosis> getDoctorDiagnosisHashMap() {
        return doctorDiagnosisHashMap;
    }
}
