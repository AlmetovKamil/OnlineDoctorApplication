package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Otolaryngologist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sinusitis extends Diagnosis {
    public Sinusitis() throws Exception {
        name = "Sinusitis";
    }

    public void initializeDoctors() throws Exception {
        if(this.getDoctors().size() == 0){
            addDoctor("Surabh Pall");
        }
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if(this.getDoctors().size() == 0 || this.transitions.size() == 0){
            addDoctor("Surabh Pall");
        }
        transitions = new ArrayList<>(
                List.of(
                        new SymptomTransition("Headache", getDiagnosisByName("SARS"))
                )
        );
    }
}
