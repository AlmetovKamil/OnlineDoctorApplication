package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.staff.Therapist;

import java.util.ArrayList;
import java.util.Arrays;

public class SARS extends Diagnosis {
    public SARS() throws Exception {
        name = "SARS";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if(this.getDoctors().size() == 0 || this.transitions.size() == 0){
            this.addDoctor("Mikhail Gorodetskiy");
        }
        transitions = new ArrayList<>();
    }
}
