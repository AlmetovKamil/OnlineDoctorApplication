package org.onlinedoctorapplication;

import org.onlinedoctorapplication.diagnoses.*;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represents main application. It's the context in the State pattern
 */
public class OnlineDoctorApplication {
    /**
     * List of all  available symptoms
     */
    private final ArrayList<String> symptoms;
    /**
     * Map of transitions. Key - symptom's name, value - endpoint of transition (diagnosis)
     */
    private final HashMap<String, Diagnosis> diagnosisHashMap;
    /**
     * Map of doctors. Key - doctor's name, value, reference to Doctor class
     */
    private final HashMap<String, Doctor> doctors;
    /**
     * Map, where key - doctor, value, diagnosis that is the speciality of the doctor
     */
    private final HashMap<Doctor, Diagnosis> doctorDiagnosisHashMap;
    /**
     * Patient that uses that application (Each user uses their own instance of application)
     */
    private final Patient patient;
    /**
     * Dialog that establishes communication between patient and app
     */
    private final IDialog dialog;
    /**
     * Current state of context (current diagnosis)
     */
    private Diagnosis state;

    /**
     * Constructor that specifies lists of diagnosis, doctors, symptoms and initializes all necessary fields
     * @param patient patient for whom the app instance is created
     * @param dialog specific version of dialog that will be used in that app instance (e.g. ConsoleDialog)
     */
    public OnlineDoctorApplication(Patient patient, IDialog dialog) throws Exception {
        this.diagnosisHashMap = new HashMap<>(16) {{
            put("flu", new Flu());
            put("allergy", new Allergy());
            put("bronchitis", new Bronchitis());
            put("healthy", new Healthy());
            put("icp", new ICP());
            put("migraine", new Migraine());
            put("sars", new SARS());
            put("sinusitis", new Sinusitis());
        }};
        this.doctors = new HashMap<>(16) {{
            put("Nikita Kudasov", new Therapist("Nikita Kudasov"));
            put("Vladimir Zouev", new Allergist("Vladimir Zouev"));
            put("Andrey Holodov", new Neurologist("Andrey Holodov"));
            put("Mikhail Gorodetskiy", new Therapist("Mikhail Gorodetskiy"));
            put("Surabh Pall", new Otolaryngologist("Surabh Pall"));
            put("Adil Khan", new Therapist("Adil Khan"));
            put("Sergey Ivanov", new Therapist("Sergey Ivanov"));
            put("Muwaffaq Imam", new Neurologist("Muwaffaq Imam"));
        }};
        this.doctorDiagnosisHashMap = new HashMap<>(16);
        this.state = this.diagnosisHashMap.get("healthy");
        this.state.setApplication(this);
        this.state.initializeDoctorsAndTransitions();
        this.patient = patient;
        this.patient.setLastDiagnosis(this.state);
        this.dialog = dialog;
        this.symptoms = new ArrayList<>() {{
            add("Сough");
            add("Headache");
            add("Sneezing");
        }};
    }

    public void changeDiagnosis(Diagnosis state) {
        this.state = state;
    }

    /**
     * Method that prints information about current diagnosis using dialog
     */
    public void showDiagnosis() {
        state.printMe(dialog);
    }

    /**
     * Method that asks user about their symptoms using dialog. After user finishes choosing their symptoms,
     * method prints all doctors that are the specialists in that sphere
     */
    public void defineSymptoms() throws Exception {
        boolean haveMoreSymptoms = true;
        while (haveMoreSymptoms) {
            haveMoreSymptoms = state.nextDiagnosis(dialog);
        }
        showDiagnosis();
        patient.setLastDiagnosis(state);
        dialog.printInformation(state.printDoctors());
    }

    /**
     * Method that allows to make an appointment with a doctor
     */
    public void bookingDoctor() {
        dialog.printInformation("Choose the doctor for booking (write the number) : ");
        int j = Integer.parseInt(dialog.optionList(patient.getLastDiagnosis().printDoctors())) - 1;
        dialog.printInformation("You booked " + patient.getLastDiagnosis().getDoctors().get(j).getFullName() + " in 10AM.");
    }

    /**
     * Method that allows to communicate with a doctor
     */
    public void discussionWithDoctor() {
        dialog.printInformation("Choose the doctor for conversation (write the number) : ");
        int j = Integer.parseInt(dialog.optionList(patient.getLastDiagnosis().printDoctors())) - 1;
        dialog.askQuestion(patient, patient.getLastDiagnosis().getDoctors().get(j));
    }

    /**
     * Method that gives information whether the patient has the symptom
     * @param symptom name of checking symptom
     * @return true is the patient has the symptom
     */
    public boolean hasSymptom(String symptom) {
        return symptoms.contains(symptom);
    }

    /**
     * Method that gives information whether the patient has the symptom
     * @param diagnosis name of checking diagnosis
     * @return true is the patient has the diagnosis
     */
    public boolean hasDiagnosis(String diagnosis) {
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
