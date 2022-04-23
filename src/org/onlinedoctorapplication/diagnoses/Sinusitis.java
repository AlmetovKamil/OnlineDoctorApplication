package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Otolaryngologist;

import java.util.ArrayList;
import java.util.List;

public class Sinusitis extends Diagnosis {
    Sinusitis() {
        name = "Sinusitis";
        doctors.add(new Otolaryngologist("Surabh Pall"));
        transitions = new ArrayList<>(List.of(new SymptomTransition("Headache", new SARS())));
    }
}
