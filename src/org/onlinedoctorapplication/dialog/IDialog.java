package org.onlinedoctorapplication.dialog;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.Patient;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.diagnoses.Diagnosis;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.List;

/**
 * Interface for a dialog - class that is responsible for communication between a user and the app.
 */
public interface IDialog {
    /**
     * Method that send question to the doctor from the patient
     */
    void askQuestion(Patient patient, Doctor doctor);

    /**
     * Method that asks user for choosing their symptoms among available.
     * @param symptoms list of available symptoms
     * @return the diagnoses by chosen symptoms
     */
    Diagnosis chooseSymptom(List<SymptomTransition> symptoms);

    /**
     * Prints the given information
     */
    void printInformation(String information);

    /**
     * Asks for user personal information.
     * @return the Patient class instance with given information
     * @throws Exception if user's input is incorrect
     */
    Patient getUserInformation() throws Exception;

    /**
     * Method that asks user to choose something that is specified in options
     * @param options specify what exactly user need to choose
     * @return user's response (the whole line with their answer)
     */
    String optionListWithLine(String options);

    /**
     * Method that asks user to choose something that is specified in options
     * @param options specify what exactly user need to choose
     * @return user's response (the line with their answer until space symbol)
     */
    String optionList(String options);

    /**
     * Method that gives user initial option list
     * @return the chosen option
     */
    String optionList();

    /**
     * Interacts with admin and allows them to enter the admin panel
     * @param doctorApplication app that is administrated
     * @throws Exception in case of incorrect input
     */
    void openAdminPanel(OnlineDoctorApplication doctorApplication) throws Exception;
}
