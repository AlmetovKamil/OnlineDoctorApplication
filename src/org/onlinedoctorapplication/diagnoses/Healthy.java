package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that represents Healthy diagnosis (one of the states)
 */
public class Healthy extends Diagnosis {
    public Healthy() throws Exception {
        name = "Healthy person";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        this.addDoctor("Adil Khan");
        transitions = new ArrayList<>(
                Arrays.asList(
                        new SymptomTransition("Cough", getDiagnosisByName("Bronchitis")),
                        new SymptomTransition("Headache", getDiagnosisByName("Migraine")),
                        new SymptomTransition("Sneezing", getDiagnosisByName("Allergy"))
                )
        );
    }
}
