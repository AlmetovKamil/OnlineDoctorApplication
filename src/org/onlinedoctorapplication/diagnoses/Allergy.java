package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Allergoloc;

import java.util.ArrayList;
import java.util.Arrays;

public class Allergy extends Diagnosis {
    public Allergy(){
        name = "Allergy";
        doctors.add(new Allergoloc("Vladimir Zouev"));
        transitions = new ArrayList<>(Arrays.asList(new SymptomTransition("Headache", new Flu()), new SymptomTransition("Cough", new Sinusitis())));
    }
}

