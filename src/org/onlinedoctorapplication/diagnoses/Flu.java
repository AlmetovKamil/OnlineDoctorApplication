package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents Flu diagnosis (one of the states)
 */
public class Flu extends Diagnosis {
    public Flu() throws Exception {
        name = "Flu";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        this.addDoctor("Nikita Kudasov");
        transitions = new ArrayList<>(
                List.of(new SymptomTransition("Cough", getDiagnosisByName("SARS")))
        );
    }
}
