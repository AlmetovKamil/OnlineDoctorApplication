package org.onlinedoctorapplication.dialog;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.Patient;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.diagnoses.Diagnosis;
import org.onlinedoctorapplication.staff.Admin;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.List;
import java.util.Scanner;

/**
 * Class that implements IDialog using console for interaction.
 */
public class ConsoleDialog implements IDialog {

    /**
     * Scanner is used to receive responses from users
     */
    private final Scanner scanner = new Scanner(System.in);
    /**
     * admin password
     */
    private final String password = "12345";

    @Override
    public void askQuestion(Patient patient, Doctor doctor) {
        System.out.print("Ask a question: ");
        scanner.nextLine();
        System.out.println(doctor.answerPatientQuestion(patient, scanner.nextLine()));
    }

    @Override
    public Diagnosis chooseSymptom(List<SymptomTransition> symptoms) {
        System.out.println("Type the number of symptom:");
        for (int i = 0; i < symptoms.size(); i++) {
            System.out.println((i + 1) + ") " + symptoms.get(i).getName());
        }
        System.out.println((symptoms.size() + 1) + ") I have no more symptom");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < symptoms.size()) {
            return symptoms.get(index).getDiagnosis();
        } else if (index == symptoms.size()) {
            return null;
        } else {
            System.out.println("Wrong index. Try again!");
            return chooseSymptom(symptoms);
        }
    }

    public void printInformation(String information) {
        System.out.println(information);
    }

    public Patient getUserInformation() throws Exception {
        System.out.println("Enter your data in format 'surname' 'name' 'age'");
        String surname = scanner.next(), name = scanner.next();
        int age = scanner.nextInt();
        return new Patient(surname, name, age);
    }

    public String optionList() {
        System.out.println("Please, choose that you want:\n" +
                "1) Get diagnosis\n" +
                "2) Admin panel\n" +
                "3) Ask a question to doctor\n" +
                "4) Book an appointment with a doctor\n" +
                "5) Quit");
        return scanner.next();
    }

    public String optionListWithLine(String options) {
        System.out.println(options);
        return scanner.nextLine().toLowerCase();
    }

    public String optionList(String options) {
        System.out.println(options);
        return scanner.next().toLowerCase();
    }

    public void openAdminPanel(OnlineDoctorApplication doctorApplication) throws Exception {
        while (true) {
            printInformation("Enter your password: ");
            String enteredString = scanner.next();
            if (enteredString.equals(password)) {
                break;
            } else if (enteredString.equals("Q")) {
                return;
            } else {
                System.out.println("Wrong password");
                System.out.println("Try again. Enter Q if you want to leave");
            }
        }
        Admin admin = new Admin(doctorApplication);
        boolean runningTrigger = true;
        String options = "Choose an action:\n" +
                "1) Show doctors\n" +
                "2) Show doctor for diagnosis\n" +
                "3) Set doctor's salary\n" +
                "4) Show doctors' salaries\n" +
                "5) Show doctor's timetable\n" +
                "6) Show doctors' timetables\n" +
                "7) Change doctors timetable\n" +
                "8)Add doctor to diagnosis\n" +
                "9)Show diagnosis info\n" +
                "10) Leave admin panel";
        while (runningTrigger) {
            switch (optionList(options)) {
                case "1" -> System.out.println(admin.showAllDoctors());
                case "2" -> {
                    scanner.nextLine();
                    System.out.println(admin.showDoctorsForDiagnosis(optionListWithLine("Enter diagnosis: ")));
                }
                case "3" -> {
                    System.out.println(admin.showDoctorsSalaries());
                    scanner.nextLine();
                    admin.setDoctorSalary(
                            optionListWithLine("Enter doctor: "),
                            Integer.parseInt(optionListWithLine("Enter new salary:"))
                    );
                }
                case "4" -> System.out.println(admin.showDoctorsSalaries());
                case "5" -> {
                    System.out.println(admin.showAllDoctors());
                    scanner.nextLine();
                    System.out.println(admin.showTimeTable(optionListWithLine("Enter doctor full name: ")));
                }
                case "6" -> System.out.println(admin.showAllTimeTables());
                case "7" -> {
                    System.out.println(admin.showAllTimeTables());
                    scanner.nextLine();
                    admin.changeTimeTable(
                            optionListWithLine("Enter doctor full name: "),
                            optionListWithLine("Enter new timetable: ")
                    );
                    System.out.println("Changes applied successfully");
                }
                case "8" -> {
                    System.out.println(admin.showAllDoctors());
                    scanner.nextLine();
                    admin.addDoctorsToDiagnosis(
                            optionListWithLine("Enter diagnosis: "),
                            optionListWithLine("Enter doctor full name: ")
                    );
                    System.out.println("Changes applied successfully");
                }
                case "9" -> {
                    scanner.nextLine();
                    System.out.println(admin.getDiagnosisInfo(optionListWithLine("Enter diagnosis: ")));
                }
                case "10" -> runningTrigger = false;
            }
        }
        System.out.println("Here you can change doctor's time tables, " +
                "add doctors and diagnoses, get patient's information.");
        System.out.println("...applying changes");
        System.out.println("Your changes applied\nThank you!");
    }
}
