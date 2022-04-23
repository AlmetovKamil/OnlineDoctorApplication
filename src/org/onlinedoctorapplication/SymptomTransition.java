package org.onlinedoctorapplication;

import org.onlinedoctorapplication.diagnoses.Diagnosis;

public class SymptomTransition {
    private final String name;
    private final Diagnosis diagnosis;

    public SymptomTransition(String name, Diagnosis diagnosis) {
        this.name = name;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
