package org.onlinedoctorapplication.staff;

/**
 * Class that represents therapist doctor
 */
public class Therapist extends Doctor {
    public Therapist(String fullName) {
        super(fullName);
        speciality = "Therapist";
    }
}
