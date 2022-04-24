package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Neurologist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Migraine extends Diagnosis {
    public Migraine() throws Exception {
        name = "Migraine";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if(this.getDoctors().size() == 0 || this.transitions.size() == 0){
            addDoctor("Andrey Holodov");
        }
        transitions = new ArrayList<>(
                Arrays.asList(
                        new SymptomTransition("Sneezing", getDiagnosisByName("Flu")),
                        new SymptomTransition("Cough", getDiagnosisByName("ICP"))
                )
        );
    }
}
