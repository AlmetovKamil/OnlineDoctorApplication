package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.Neurologist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ICP extends Diagnosis {
    public ICP() throws Exception {
        name = "Intracranial Pressure";
    }

    public void initializeDoctors() throws Exception {
        if(this.getDoctors().size() == 0){
            this.addDoctor("Muwaffaq Imam");
        }
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if(this.getDoctors().size() == 0 || this.transitions.size() == 0){
            this.addDoctor("Muwaffaq Imam");
        }
        transitions = new ArrayList<>(
                List.of(
                        new SymptomTransition("Sneezing",
                                getDiagnosisByName("SARS"))
                )
        );
    }
}