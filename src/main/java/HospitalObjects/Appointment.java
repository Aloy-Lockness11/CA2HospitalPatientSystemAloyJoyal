package HospitalObjects;

import java.time.LocalDate;

public class Appointment {
    private String patientFirstName;
    private String patientLastName;
    //date of birth
    private LocalDate DoB;
    private String issue;
    private LocalDate date;
    private int triage;
    private String doctorFullName;

    //Default constructor
    public Appointment() {
    }

    //Constructor
    public Appointment(String patientFirstName, String patientLastName, LocalDate DoB, String issue, LocalDate date, int triage, String doctorFullName) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.DoB = DoB;
        this.issue = issue;
        this.date = date;
        this.triage = triage;
        this.doctorFullName = doctorFullName;
    }
    //Getters
    //returns a copy of the patient's first name
    public String getPatientFirstName() {
        return patientFirstName;
    }
    public String getPatientLastName() {
        return patientLastName;
    }
    public LocalDate getDoB() {
        return DoB;
    }
    public String getIssue() {
        return issue;
    }
    public LocalDate getDate() {
        return date;
    }
    public int getTriage() {
        return triage;
    }
    public String getDoctorFullName() {
        return doctorFullName;
    }
}