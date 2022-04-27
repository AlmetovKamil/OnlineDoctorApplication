package org.onlinedoctorapplication.diagnoses;

import java.util.ArrayList;

/**
 * Class that represents SARS diagnosis (one of the states)
 */
public class SARS extends Diagnosis {
    public SARS() throws Exception {
        name = "SARS";
    }

    public void initializeDoctorsAndTransitions() throws Exception {
        this.addDoctor("Mikhail Gorodetskiy");
        transitions = new ArrayList<>();
    }
}
