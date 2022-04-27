package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.ArrayList;
import java.util.Map;

/**
 * Abstract class that represents a state (in State pattern)
 */
public abstract class Diagnosis {
    /**
     * List of doctors that are specialists in this sphere
     */
    private final ArrayList<Doctor> doctors = new ArrayList<>();
    /**
     * Instance of app
     */
    protected OnlineDoctorApplication doctorApplication;
    /**
     * List of possible transitions (symptoms) from that state
     */
    protected ArrayList<SymptomTransition> transitions;
    /**
     * Name of diagnosis
     */
    protected String name;
    /**
     * Flag that says whether the diagnosis has been initialized.
     * (to not repeat the same diagnosis)
     */
    protected boolean initialized;

    /**
     * Setter of application
     */
    public void setApplication(OnlineDoctorApplication app) {
        doctorApplication = app;
    }

    /**
     * Prints the information about the diagnosis using dialog
     */
    public void printMe(IDialog dialog) {
        dialog.printInformation("Your diagnosis is " + name);
    }

    /**
     * Method that adds new transition (symptom) from that state
     *
     * @param symptom new symptom (transition)
     * @param to      ending point of transition
     * @throws Exception if symptom or diagnosis doesn't exist
     */
    public void addTransition(String symptom, String to) throws Exception {
        if (doctorApplication.hasSymptom(symptom) && doctorApplication.hasDiagnosis(to)) {
            SymptomTransition newSymptomTransition = new SymptomTransition(symptom, getDiagnosisByName(to));
            if (!transitions.contains(newSymptomTransition)) {
                transitions.add(new SymptomTransition(symptom, getDiagnosisByName(to)));
            } else {
                throw new Exception("Symptom or Diagnosis does not exist");
            }
        }
    }

    /**
     * Method that adds new doctor - specialist in this sphere among the available doctors from the app
     *
     * @param fullName full name of the doctor
     * @throws Exception if there is no such doctor in the app
     */
    public void addDoctor(String fullName) throws Exception {
        if (doctorApplication.getDoctors().containsKey(fullName)) {
            this.doctors.add(this.doctorApplication.getDoctors().get(fullName));
        } else {
            throw new Exception("No such doctor");
        }
    }

    public Diagnosis getDiagnosisByName(String nameDiagnosis) {
        return doctorApplication.getDiagnosisHashMap().get(nameDiagnosis);
    }

    /**
     * Method that applies the transition from current diagnoses to a new one. It asks user to choose new symptom
     * among available (that are the transitions) and uses their response for performing transition.
     *
     * @param dialog is needed to communicate with user
     * @return true if the transition has been applied successfully
     */
    public boolean nextDiagnosis(IDialog dialog) throws Exception {
        Diagnosis newDiagnosis = dialog.chooseSymptom(transitions);
        if (newDiagnosis != null) {
            newDiagnosis.setApplication(doctorApplication);
            doctorApplication.changeDiagnosis(newDiagnosis);
            if (!newDiagnosis.initialized) {
                newDiagnosis.initializeDoctorsAndTransitions();
                newDiagnosis.initialized = true;
            }
            newDiagnosis.update();
            return true;
        }
        return false;
    }

    /**
     * Updates the doctors of the current diagnoses
     */
    public void update() throws Exception {
        for (Map.Entry<Doctor, Diagnosis> doctorDiagnosisEntry :
                doctorApplication.getDoctorDiagnosisHashMap().entrySet()) {
            if (doctorDiagnosisEntry.getValue().name.equals(this.name) &&
                    !this.doctors.contains(doctorDiagnosisEntry.getKey().getFullName())) {
                addDoctor(doctorDiagnosisEntry.getKey().getFullName());
            }
        }
    }

    /**
     * Returns the string representation of doctors list
     */
    public String printDoctors() {
        String docs = "";
        int i = 1;
        for (Doctor x : doctors) {
            docs += i + ") " + x.getFullName() + " Timetable: " + x.getTimeTable() + "\n";
            i++;
        }
        return docs;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public String getName() {
        return name;
    }

    /**
     * Method that initializes list of doctors and transitions for the particular diagnoses
     * @throws Exception if doctors or transitions are not present in the app
     */
    public abstract void initializeDoctorsAndTransitions() throws Exception;

}
