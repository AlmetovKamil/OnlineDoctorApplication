package org.onlinedoctorapplication.diagnoses;

import java.util.ArrayList;

public class SARS extends Diagnosis {
    public SARS() throws Exception {
        name = "SARS";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        this.addDoctor("Mikhail Gorodetskiy");
        transitions = new ArrayList<>();
    }
}
