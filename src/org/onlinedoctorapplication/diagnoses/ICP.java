package org.onlinedoctorapplication.diagnoses;

import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.dialog.IDialog;
import org.onlinedoctorapplication.staff.Neurologist;

import java.util.ArrayList;
import java.util.List;

public class ICP extends Diagnosis {
    ICP(){
        name = "Intracranial Pressure";
        doctors.add(new Neurologist("Muwaffaq Imam"));
        transitions = new ArrayList<>(List.of(new SymptomTransition("Sneezing", new SARS())));
    }
}