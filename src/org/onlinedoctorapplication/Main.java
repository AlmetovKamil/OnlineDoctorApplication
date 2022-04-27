package org.onlinedoctorapplication;

import org.onlinedoctorapplication.dialog.ConsoleDialog;
import org.onlinedoctorapplication.dialog.IDialog;

/**
 * Class with business logic
 */
public class Main {
    public static void main(String[] args) throws Exception {
        IDialog dialog = new ConsoleDialog();
        // ask user their personal data
        Patient patient1 = dialog.getUserInformation();
        // create instance of the app for the patient
        OnlineDoctorApplication app = new OnlineDoctorApplication(patient1, dialog);
        // suggest user options to choose until they finish interact with app
        boolean runFlag = true;
        while (runFlag) {
            switch (dialog.optionList()) {
                case "1" -> app.defineSymptoms();
                case "2" -> dialog.openAdminPanel(app);
                case "3" -> app.discussionWithDoctor();
                case "4" -> app.bookingDoctor();
                case "5" -> runFlag = false;
            }
        }
    }
}
