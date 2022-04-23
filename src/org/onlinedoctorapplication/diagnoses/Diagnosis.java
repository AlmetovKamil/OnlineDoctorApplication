package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.ArrayList;

public abstract class Diagnosis {

    protected ArrayList<Doctor> doctors = new ArrayList<>();
    private OnlineDoctorApplication doctorApplication;
    protected ArrayList<SymptomTransition> transitions;
    protected String name;

    public void setApplication(OnlineDoctorApplication app) {
        doctorApplication = app;
    }

    public void printMe(IDialog dialog) {
        System.out.println("Your diagnosis is " + name);
    }

    public boolean nextDiagnosis(IDialog dialog) {
        Diagnosis newDiagnosis = dialog.chooseSymptom(transitions);
        if (newDiagnosis != null) {
            newDiagnosis.setApplication(doctorApplication);
            doctorApplication.changeDiagnosis(newDiagnosis);
            return true;
        }
        return false;
    }

    public String printDoctors(){
        String docs = "";
        int i = 1;
        for (Doctor x : doctors){
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
}
