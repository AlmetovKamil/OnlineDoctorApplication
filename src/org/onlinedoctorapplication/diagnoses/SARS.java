package org.onlinedoctorapplication.diagnoses;

import java.util.ArrayList;

public class SARS extends Diagnosis {
    public SARS() throws Exception {
        name = "SARS";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        if (this.getDoctors().size() == 0 || this.transitions.size() == 0) {
            this.addDoctor("Mikhail Gorodetskiy");
        }
        transitions = new ArrayList<>();
    }
}
