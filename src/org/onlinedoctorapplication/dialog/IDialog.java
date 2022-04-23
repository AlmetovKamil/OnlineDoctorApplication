package org.onlinedoctorapplication.dialog;

import org.onlinedoctorapplication.Patient;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.diagnoses.Diagnosis;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.List;

public interface IDialog {
    void askQuestion(Patient patient, Doctor doctor);
    Diagnosis chooseSymptom(List<SymptomTransition> symptoms);
    void printInformation(String information);
    Patient getUserInformation();
    String optionList(String options);
    String optionList();
    void openAdminPanel();
}
