package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.staff.Therapist;

import java.util.ArrayList;

public class SARS extends Diagnosis {
    SARS (){
        name = "SARS";
        doctors.add(new Therapist("Mikhail Gorodetskiy"));
        transitions = new ArrayList<>();
    }
}
