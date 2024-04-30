package HospitalObjects;

import java.io.Serializable;
import java.time.LocalDate;
/*
 * Appointment class to store the details of the appointment
 * @version 1.0
 * @Author Aloy
 *
 */

public class Appointment implements Serializable {
    private String patientFirstName;
    private String patientLastName;
    //date of birth
    private LocalDate DoB;
    private String issue;
    private LocalDate date;
    private int triage;
    private String doctorFullName;

    /*
     * Default constructor
     */
    //Default constructor
    public Appointment() {
    }

    /*
     * Constructor to create an appointment
     * @param patientFirstName
     * @param patientLastName
     * @param DoB Date of birth of the patient less than today
     * @param issue  Issue of the patient between 1 and 500 characters
     * @param date  date of the appointment between today and the future
     * @param triage  triage of the patient between 1 and 5
     * @param doctorFullName
     */
    //Constructor
    public Appointment(String patientFirstName, String patientLastName, LocalDate DoB, String issue, LocalDate date, int triage, String doctorFullName) {
        try {
            setPatientFirstName(patientFirstName);
            setPatientLastName(patientLastName);
            setDoB(DoB);
            setIssue(issue);
            setTriage(triage);
            setDate(date);
            setDoctorFullName(doctorFullName);
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
    /*
     * Setter  to set patient first name
     * @param patientFirstName
     * @throws IllegalArgumentException if patient first name is empty
     */
    public void setPatientFirstName(String patientFirstName) {
        if (patientFirstName == null || patientFirstName.isEmpty()) {
            throw new IllegalArgumentException("Patient first name cannot be empty");
        }
        this.patientFirstName = patientFirstName;
    }

    /*
     * Setter  to set patient last name
     * @param patientLastName
     * @throws IllegalArgumentException if patient last name is empty
     */
    public void setPatientLastName(String patientLastName) {
        if (patientLastName == null || patientLastName.isEmpty()) {
            throw new IllegalArgumentException("Patient last name cannot be empty");
        }
        this.patientLastName = patientLastName;
    }

    /*
     * Setter  to set patient date of birth
     * @param DoB
     * @throws IllegalArgumentException if date of birth is empty
     * @throws IllegalArgumentException if date of birth is in the future
     */
    public void setDoB(LocalDate DoB) {
        if (DoB == null) {
            throw new IllegalArgumentException("Date of birth cannot be empty");
        } else if (DoB.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
        this.DoB = DoB;
    }

    /*
     * Setter  to set patient issue
     * @param issue
     * @throws IllegalArgumentException if issue is empty
     * @throws IllegalArgumentException if issue is more than 500 characters
     */
    public void setIssue(String issue) {
        if (issue == null || issue.isEmpty()) {
            throw new IllegalArgumentException("Issue cannot be empty");
        }
        if (issue.length() > 500) {
            throw new IllegalArgumentException("Issue cannot be more than 500 characters");

        }
        this.issue = issue;
    }

    /*
     * Setter  to set appointment date
     * @param date
     * @throws IllegalArgumentException if date is empty
     * @throws IllegalArgumentException if date is in the past
     */
    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be empty");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be in the past");
        }
        this.date = date;
    }

    /*
     * Setter  to set triage
     * @param triage
     * @throws IllegalArgumentException if triage is less than 1
     * @throws IllegalArgumentException if triage is more than 5
     */
    public void setTriage(int triage) {
        if (triage < 1 || triage > 5) {
            throw new IllegalArgumentException("Triage must be between 1 and 5");
        }
        this.triage = triage;
    }

    /*
     * Setter  to set doctor full name
     * @param doctorFullName
     * @throws IllegalArgumentException if doctor full name is empty
     */
    public void setDoctorFullName(String doctorFullName) {
        if (doctorFullName == null || doctorFullName.isEmpty()) {
            throw new IllegalArgumentException("Doctor full name cannot be empty");
        }
        this.doctorFullName = doctorFullName;
    }

}