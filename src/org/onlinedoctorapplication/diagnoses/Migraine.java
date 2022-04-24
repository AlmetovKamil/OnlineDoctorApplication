package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;

import java.util.ArrayList;
import java.util.Arrays;

public class Migraine extends Diagnosis {
    public Migraine() throws Exception {
        name = "Migraine";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        addDoctor("Andrey Holodov");
        transitions = new ArrayList<>(
                Arrays.asList(
                        new SymptomTransition("Sneezing", getDiagnosisByName("Flu")),
                        new SymptomTransition("Cough", getDiagnosisByName("ICP"))
                )
        );
    }
}
