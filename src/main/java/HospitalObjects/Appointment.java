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
    //Constructor
    public Appointment(String patientFirstName, String patientLastName, LocalDate DoB, String issue, LocalDate date, int triage, String doctorFullName) {
        try {
            setPatientFirstName(patientFirstName);
            setPatientLastName(patientLastName);
            setDoB(DoB);
            setIssue(issue);
            setTriage(triage);
            setDoctorFullName(doctorFullName);
            this.date=LocalDate.now();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
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
    //setters
    public void setPatientFirstName(String patientFirstName) {
        if (patientFirstName == null || patientFirstName.isEmpty()) {
            throw new IllegalArgumentException("Patient first name cannot be empty");
        }
        this.patientFirstName = patientFirstName;
    }
    public void setPatientLastName(String patientLastName) {
        if (patientLastName == null || patientLastName.isEmpty()) {
            throw new IllegalArgumentException("Patient last name cannot be empty");
        }
        this.patientLastName = patientLastName;
    }
    public void setDoB(LocalDate DoB) {
        if (DoB == null) {
            throw new IllegalArgumentException("Date of birth cannot be empty");
        }else if (DoB.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
        this.DoB = DoB;
    }
    public void setIssue(String issue) {
        if (issue == null || issue.isEmpty()) {
            throw new IllegalArgumentException("Issue cannot be empty");
        }
        if (issue.length() > 500) {
            throw new IllegalArgumentException("Issue cannot be more than 500 characters");

        }
        this.issue = issue;
    }
    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be empty");
        }
        this.date = date;
    }
    public void setTriage(int triage) {
        if (triage < 1 || triage > 5) {
            throw new IllegalArgumentException("Triage must be between 1 and 5");
        }
        this.triage = triage;
    }
    public void setDoctorFullName(String doctorFullName) {
        if (doctorFullName == null || doctorFullName.isEmpty()) {
            throw new IllegalArgumentException("Doctor full name cannot be empty");
        }
        this.doctorFullName = doctorFullName;
    }

}