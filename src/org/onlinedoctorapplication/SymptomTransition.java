package org.onlinedoctorapplication;

import org.onlinedoctorapplication.diagnoses.Diagnosis;

/**
 * Class that represents a symptom (symptom is a transition in the State design pattern)
 */
public class SymptomTransition {
    private final String name;
    /**
     * Ending point if the transition (diagnosis)
     */
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
