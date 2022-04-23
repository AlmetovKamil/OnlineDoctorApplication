package org.onlinedoctorapplication.dialog;

import org.onlinedoctorapplication.Patient;
import org.onlinedoctorapplication.SymptomTransition;
import org.onlinedoctorapplication.diagnoses.Diagnosis;
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

    public Patient getUserInformation() {
        System.out.println("Enter your data in format 'name' 'surname' 'age'");
        String name = scanner.next(), surname = scanner.next();
        int age = scanner.nextInt();
        return new Patient(name, surname, age);
    }

    public void printDoctors(Diagnosis diagnosis){
        System.out.println(diagnosis.printDoctors());
    }

    public String optionList(){
        System.out.println("Please, choose that you want:\n1) Get diagnosis\n2) Admin panel\n3) Ask a question to doctor\n4) Book an appointment with a doctor\n5) Quit");
        return scanner.next();
    }

    public String optionList(String options){
        System.out.println(options);
        return scanner.next();
    }

    public void openAdminPanel(){
        if(!scanner.next().equals(password))
            return;
        System.out.println("Here you can change doctor's time tables, add doctors and diagnoses, get patient's information.");
        System.out.println("...applying changes");
        System.out.println("Your changes applied\nThank you!");
    }
}