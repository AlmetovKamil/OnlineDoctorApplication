package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents ICP diagnosis (one of the states)
 */
public class ICP extends Diagnosis {
    public ICP() throws Exception {
        name = "Intracranial Pressure";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        this.addDoctor("Muwaffaq Imam");
        transitions = new ArrayList<>(
                List.of(new SymptomTransition("Sneezing", getDiagnosisByName("SARS")))
        );
    }
}
