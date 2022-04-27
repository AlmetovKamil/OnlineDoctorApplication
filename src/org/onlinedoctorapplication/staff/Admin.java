package org.onlinedoctorapplication.staff;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.Patient;

/**
 * Class that represents admin
 */
public class Admin {
    /**
     * Instance of the application
     */
    private final OnlineDoctorApplication doctorApplication;

    public Admin(OnlineDoctorApplication doctorApplication) {
        this.doctorApplication = doctorApplication;
    }

    /**
     * Method that shows a doctor's timetable
     *
     * @param doctor which timetable is required
     * @return timetable of the doctor
     * @throws Exception if there is no such doctor in the app
     */
    public String showTimeTable(String doctor) throws Exception {
        if (doctorApplication.getDoctors().containsKey(doctor)) {
            return doctorApplication.getDoctors().get(doctor).getTimeTable();
        } else {
            throw new Exception("No such doctor");
        }
    }

    /**
     * Method that changes a doctor's timetable
     *
     * @param doctor  which timetable is changing
     * @param newTime new timetable
     * @throws Exception if there is no such doctor
     */
    public void changeTimeTable(String doctor, String newTime) throws Exception {
        if (doctorApplication.getDoctors().containsKey(doctor)) {
            doctorApplication.getDoctors().get(doctor).setTimeTable(newTime);
        } else {
            throw new Exception("No such doctor");
        }
    }

    /**
     * Method that shows all doctors
     *
     * @return string with all doctors' names and specialities
     */
    public String showAllDoctors() {
        String res = "Doctors:\n";
        for (Doctor doctor : doctorApplication.getDoctors().values()) {
            res += doctor.getSpeciality() + " " + doctor.getFullName() + "\n";
        }
        return res;
    }

    /**
     * Method that shows doctors' salaries
     *
     * @return string with doctors' information (full name, speciality, and salary)
     */
    public String showDoctorsSalaries() {
        String res = "Doctors:\n";
        for (Doctor doctor : doctorApplication.getDoctors().values()) {
            res += doctor.getSpeciality() + " " + doctor.getFullName() + " " + doctor.getSalary() + "\n";
        }
        return res;
    }

    /**
     * Method that finds all doctors that are specialist in curing particular diagnosis
     *
     * @param diagnosis that is considering
     * @return string with all doctors that are specialists in that sphere. If there are no such doctors, returns:
     * "There are no specialists or diagnosis is not actual yet"
     * @throws Exception if there is no such diagnosis
     */
    public String showDoctorsForDiagnosis(String diagnosis) throws Exception {
        String res = "Doctors:\n";
        if (doctorApplication.getDiagnosisHashMap().containsKey(diagnosis.toLowerCase())) {
            if (doctorApplication.getDiagnosisHashMap().get(diagnosis).getDoctors().size() != 0) {
                for (Doctor doctor : doctorApplication.getDiagnosisHashMap().get(diagnosis).getDoctors()) {
                    res += doctor.getSpeciality() + " " + doctor.getFullName() + "\n";
                }
            } else {
                return "There are no specialists or diagnosis is not actual yet";
            }
        } else {
            throw new Exception("No such diagnosis");
        }
        return res;
    }

    /**
     * Method that shows doctors' timetables
     *
     * @return string with doctors' information (full name, speciality, and timetable)
     */
    public String showAllTimeTables() {
        String res = "Timetables:\n";
        for (Doctor doctor : doctorApplication.getDoctors().values()) {
            res += doctor.getSpeciality() + " " + doctor.getFullName() + "\nTime: " + doctor.getTimeTable() + "\n";
        }
        return res;
    }

    /**
     * Method that makes the doctor a specialist in curing the diagnosis
     *
     * @param diagnosis doctor's new speciality
     * @param fullName  doctor's full name
     * @throws Exception if there is no such doctor or diagnosis
     */
    public void addDoctorsToDiagnosis(String diagnosis, String fullName) throws Exception {
        if (doctorApplication.getDiagnosisHashMap().containsKey(diagnosis)) {
            if (doctorApplication.getDoctors().containsKey(fullName)) {
                doctorApplication.getDoctorDiagnosisHashMap().put(
                        doctorApplication.getDoctors().get(fullName),
                        doctorApplication.getDiagnosisHashMap().get(diagnosis)
                );
            } else {
                throw new Exception("No such doctor");
            }
        } else {
            throw new Exception("No such diagnosis");
        }
    }

    /**
     * Method that changes doctor's salary
     *
     * @param fullName doctor's full name
     * @param salary   new salary
     * @throws Exception if there is no such doctor
     */
    public void setDoctorSalary(String fullName, int salary) throws Exception {
        if (doctorApplication.getDoctors().containsKey(fullName)) {
            doctorApplication.getDoctors().get(fullName).setSalary(salary);
        } else {
            throw new Exception("No such doctor");
        }
    }

    /**
     * Method that gives the diagnosis' info
     *
     * @param diagnosisName name of considering diagnosis
     * @return string with all doctors that are specialist in curing the diagnosis
     * @throws Exception if there is no such diagnosis
     */
    public String getDiagnosisInfo(String diagnosisName) throws Exception {
        if (doctorApplication.getDiagnosisHashMap().containsKey(diagnosisName)) {
            if (doctorApplication.getDiagnosisHashMap().get(diagnosisName).getName().length() != 0) {
                return doctorApplication.getDiagnosisHashMap().get(diagnosisName).getName()
                        + "\n" + showDoctorsForDiagnosis(diagnosisName);
            } else {
                return "Diagnosis is not actual now";
            }
        } else {
            throw new Exception("No such diagnosis");
        }
    }

    /**
     * Method that gives patient's information
     *
     * @param patient considering patient
     * @return string with patient's name, surname, and their diagnoses (if present)
     */
    public String getPatientInformation(Patient patient) {
        String info = "Name:" + patient.getName() + " Surname: " + patient.getSurname();
        if (patient.getLastDiagnosis() != null) {
            info += "Diagnosis: " + patient.getLastDiagnosis().getName();
        }
        return info;
    }

    /**
     * Mathod that adds new symptom to the application
     *
     * @param symptom new symptom (transition)
     * @param from    starting point of the transition (diagnosis)
     * @param to      ending point of the transition (diagnosis)
     * @throws Exception if there is no symptom or diagnosis
     */
    public void addNewTransitionToDiagnosis(String symptom, String from, String to) throws Exception {
        if (doctorApplication.getDiagnosisHashMap().containsKey(from)) {
            doctorApplication.getDiagnosisHashMap().get(from).addTransition(from, to);
        } else {
            throw new Exception("Symptom or Diagnosis does not exist");
        }
    }
}
