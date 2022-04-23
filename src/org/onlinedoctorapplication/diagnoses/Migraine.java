package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Neurologist;

import java.util.ArrayList;
import java.util.Arrays;

public class Migraine extends Diagnosis {
    Migraine() {
        name = "Migraine";
        doctors.add(new Neurologist("Andrey Holodov"));
        transitions = new ArrayList<>(Arrays.asList(new SymptomTransition("Sneezing", new Flu()), new SymptomTransition("Cough", new ICP())));
    }
}
