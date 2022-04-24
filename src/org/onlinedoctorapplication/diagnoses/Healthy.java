package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Neurologist;
import org.onlinedoctorapplication.staff.Therapist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Healthy extends Diagnosis {
    public Healthy() throws Exception {
        name = "Healthy person";
    }


    public void initializeDoctorsAndTransitions() throws Exception {
        if(this.getDoctors().size() == 0 || this.transitions.size() == 0){
            this.addDoctor("Adil Khan");
        }
        transitions = new ArrayList<>(
                Arrays.asList(
                        new SymptomTransition("Cough", getDiagnosisByName("Bronchitis")),
                        new SymptomTransition("Headache", getDiagnosisByName("Migraine")),
                        new SymptomTransition("Sneezing", getDiagnosisByName("Allergy"))
                )
        );
    }
}
