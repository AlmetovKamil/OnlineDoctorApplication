package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Therapist;

import java.util.ArrayList;
import java.util.List;

public class Flu extends Diagnosis {
    public Flu() {
        name = "Flu";
        doctors.add(new Therapist("Nikita Kudasov"));
        transitions = new ArrayList<>(List.of(new SymptomTransition("Cough", new SARS())));
    }
}
