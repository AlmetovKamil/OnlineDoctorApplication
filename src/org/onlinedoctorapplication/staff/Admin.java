package org.onlinedoctorapplication.staff;

import org.onlinedoctorapplication.OnlineDoctorApplication;
import org.onlinedoctorapplication.Patient;

public class Admin {
    private final OnlineDoctorApplication doctorApplication;

    public Admin(OnlineDoctorApplication doctorApplication){
        this.doctorApplication = doctorApplication;
    }

    public String showTimeTable(String doctor) throws Exception {
        if(doctorApplication.getDoctors().containsKey(doctor)){
            return doctorApplication.getDoctors().get(doctor).getTimeTable();
        } else throw new Exception("No such doctor");
    }

    public void changeTimeTable(String doctor, String newTime) throws Exception {
        if(doctorApplication.getDoctors().containsKey(doctor)){
            doctorApplication.getDoctors().get(doctor).setTimeTable(newTime);
        } else throw new Exception("No such doctor");
    }

    public String showAllDoctors(){
        String res = "Doctors:\n";
        for(Doctor doctor: doctorApplication.getDoctors().values())
            res += doctor.getSpeciality() + " " + doctor.getFullName() + "\n";
        return res;
    }

    public String showAllTimeTables(){
        String res = "Timetables:\n";
        for(Doctor doctor: doctorApplication.getDoctors().values())
            res += doctor.getSpeciality() + " " + doctor.getFullName() + "\nTime: " + doctor.getTimeTable() + "\n";
        return res;
    }

    public void addDoctorsToDiagnosis(String diagnosis, String fullName) throws Exception {
        if(doctorApplication.getDiagnosisHashMap().containsKey(diagnosis))
            if(doctorApplication.getDoctors().containsKey(fullName))
                doctorApplication.getDoctorDiagnosisHashMap().put(doctorApplication.getDoctors().get(fullName), doctorApplication.getDiagnosisHashMap().get(diagnosis));
            else throw new Exception("No such doctor");
        else
            throw new Exception("No such diagnosis");
    }

    public String GetPatientInformation(Patient patient) {
        String info = "Name:" + patient.getName() + " Surname: " + patient.getSurname();
        if(patient.getLastDiagnosis() != null) {
            info += "Diagnosis: " + patient.getLastDiagnosis().getName();
        }
        return info;
    }

    public void addNewTransitionToDiagnosis(String symptom, String from, String to) throws Exception {
        if (doctorApplication.getDiagnosisHashMap().containsKey(from))
            doctorApplication.getDiagnosisHashMap().get(from).addTransition(from, to);
        else
            throw new Exception("Symptom or Diagnosis does not exist");
    }
}
