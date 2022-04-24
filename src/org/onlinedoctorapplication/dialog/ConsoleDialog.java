package org.onlinedoctorapplication.dialog;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.Patient;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.diagnoses.Diagnosis;
import org.onlinedoctorapplication.staff.Admin;
import org.onlinedoctorapplication.staff.Doctor;

import java.util.List;
import java.util.Scanner;

public class ConsoleDialog implements IDialog {

    private final Scanner scanner = new Scanner(System.in);
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

        if (index >= 0 && index < symptoms.size())
            return symptoms.get(index).getDiagnosis();
        else if (index == symptoms.size())
            return null;
        else {
            System.out.println("Wrong index. Try again!");
            return chooseSymptom(symptoms);
        }
    }

    public void printInformation(String information) {
        System.out.println(information);
    }

    public Patient getUserInformation() throws Exception {
        System.out.println("Enter your data in format 'name' 'surname' 'age'");
        String name = scanner.next(), surname = scanner.next();
        int age = scanner.nextInt();
        return new Patient(name, surname, age);
    }

    public String optionList(){
        System.out.println("Please, choose that you want:\n1) Get diagnosis\n2) Admin panel\n3) Ask a question to doctor\n4) Book an appointment with a doctor\n5) Quit");
        return scanner.next();
    }

    public String optionListWithLine(String options){
        System.out.println(options);
        return scanner.nextLine();
    }

    public String optionList(String options){
        System.out.println(options);
        return scanner.next();
    }

    public void openAdminPanel(OnlineDoctorApplication doctorApplication) throws Exception {
        printInformation("Enter your password: ");
        if(!scanner.next().equals(password)) {
            System.out.println("Wrong password");
            return;
        }
        Admin admin = new Admin(doctorApplication);
        boolean runningTrigger = true;
        while (runningTrigger) {
            switch (optionList("Choose an action:\n1) Show doctors\n2) Show doctor's timetable\n3) Show doctors' timetables\n4) Change doctors timetable\n5)Add doctor to diagnosis\n6) Leave admin panel")){
                case "1":
                    System.out.println(admin.showAllDoctors());
                    break;
                case "2":
                    System.out.println(admin.showAllDoctors());
                    System.out.println(admin.showTimeTable(optionListWithLine("Enter doctor full name: ")));
                    break;
                case "3":
                    System.out.println(admin.showAllTimeTables());
                    break;
                case "4":
                    System.out.println(admin.showAllTimeTables());
                    scanner.nextLine();
                    admin.changeTimeTable(optionListWithLine("Enter doctor full name: "), optionListWithLine("Enter new timetable: "));
                    System.out.println("Changes applied successfully");
                    break;
                case "5":
                    System.out.println(admin.showAllDoctors());
                    scanner.nextLine();
                    admin.addDoctorsToDiagnosis(optionListWithLine("Enter diagnosis: "), optionListWithLine("Enter doctor full name: "));
                    System.out.println("Changes applied successfully");
                    break;
                case "6":
                    runningTrigger = false;
                    break;
            }
        }
        System.out.println("Here you can change doctor's time tables, add doctors and diagnoses, get patient's information.");
        System.out.println("...applying changes");
        System.out.println("Your changes applied\nThank you!");
    }
}