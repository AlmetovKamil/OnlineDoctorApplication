package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.ArrayList;
import java.util.Map;

public abstract class Diagnosis {
    private final ArrayList<Doctor> doctors = new ArrayList<>();
    protected OnlineDoctorApplication doctorApplication;
    protected ArrayList<SymptomTransition> transitions;
    protected String name;
    protected boolean initialized;

    public void setApplication(OnlineDoctorApplication app) {
        doctorApplication = app;
    }

    public void printMe(IDialog dialog) {
        dialog.printInformation("Your diagnosis is " + name);
    }

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

    public void update() throws Exception {
        for (Map.Entry<Doctor, Diagnosis> doctorDiagnosisEntry : doctorApplication.getDoctorDiagnosisHashMap().entrySet()) {
            if (doctorDiagnosisEntry.getValue().name.equals(this.name) &&
                    !this.doctors.contains(doctorDiagnosisEntry.getKey().getFullName())) {
                addDoctor(doctorDiagnosisEntry.getKey().getFullName());
            }
        }
    }

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

    public void initializeDoctorsAndTransitions() throws Exception {
    }

}
