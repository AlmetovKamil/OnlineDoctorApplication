package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents Sinusitis diagnosis (one of the states)
 */
public class Sinusitis extends Diagnosis {
    public Sinusitis() throws Exception {
        name = "Sinusitis";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        addDoctor("Surabh Pall");
        transitions = new ArrayList<>(
                List.of(new SymptomTransition("Headache", getDiagnosisByName("SARS")))
        );
    }
}
