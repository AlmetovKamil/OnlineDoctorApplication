package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;

import java.util.ArrayList;
import java.util.List;

public class ICP extends Diagnosis {
    public ICP() throws Exception {
        name = "Intracranial Pressure";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if (this.getDoctors().size() == 0 || this.transitions.size() == 0) {
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