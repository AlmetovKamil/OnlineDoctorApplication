package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;

import java.util.ArrayList;
import java.util.List;

public class Sinusitis extends Diagnosis {
    public Sinusitis() throws Exception {
        name = "Sinusitis";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if (this.getDoctors().size() == 0 || this.transitions.size() == 0) {
            addDoctor("Surabh Pall");
        }
        transitions = new ArrayList<>(
                List.of(
                        new SymptomTransition("Headache", getDiagnosisByName("SARS"))
                )
        );
    }
}
