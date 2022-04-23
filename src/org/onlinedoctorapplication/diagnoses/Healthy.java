package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Neurologist;
import org.onlinedoctorapplication.staff.Therapist;

import java.util.ArrayList;
import java.util.Arrays;

public class Healthy extends Diagnosis {
    public Healthy() {
        name = "Healthy person";
        doctors.add(new Therapist("Adil Khan"));
        transitions = new ArrayList<>(
                Arrays.asList(
                        new SymptomTransition("Cough", new Bronchitis()),
                        new SymptomTransition("Headache", new Migraine()),
                        new SymptomTransition("Sneezing", new Allergy()))
        );
    }

}
