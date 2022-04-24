package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Therapist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bronchitis extends Diagnosis {
    public Bronchitis() throws Exception {
        name = "Bronchitis";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if(this.getDoctors().size() == 0 || this.transitions.size() == 0){
            this.addDoctor("Sergey Ivanov");
        }
        transitions = new ArrayList<>(
                Arrays.asList(
                        new SymptomTransition("Headache", getDiagnosisByName("ICP")),
                        new SymptomTransition("Sneezing", getDiagnosisByName("Sinusitis"))
                )
        );
    }
}