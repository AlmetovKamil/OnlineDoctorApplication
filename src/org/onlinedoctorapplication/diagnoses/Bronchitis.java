package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Therapist;

import java.util.ArrayList;
import java.util.Arrays;

public class Bronchitis extends Diagnosis {
    public Bronchitis() {
        name = "Bronchitis";
        doctors.add(new Therapist("Sergey Ivanov"));
        transitions = new ArrayList<>(Arrays.asList(new SymptomTransition("Headache", new ICP()), new SymptomTransition("Sneezing", new Sinusitis())));
    }
}