package Business;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Utils.FileOperators;
import Datastructures.BoundedPriorityQueue;
import HospitalObjects.Appointment;
import HospitalObjects.Patient;

/*
 * Applications for the Hospital to roster doctors
 * @author Aloy And Joyal
 * @version 1.0
 * */
public class App {
    private static ArrayList<BoundedPriorityQueue> doctorQueues;
    private static ArrayList<Patient> patients;
    private static Scanner sc ;
    private static Random random;
    App(){
        doctorQueues = new ArrayList<>();
        patients = new ArrayList<>();
        sc = new Scanner(System.in);
        random = new Random();
    }
    /**
     * Main method to run the application
     * @param args
     */
    public static void main(String[] args) {
        setup();
        menu();
    }
    /**
     * Method to setup the application
     */
    private static void setup(){
        System.out.println("How many doctors are available?");
        int numDoctors = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numDoctors; i++) {
            System.out.println("Enter the name of doctor " + (i + 1));
            String doctorName = sc.nextLine();
            System.out.println("Enter the maximum number of appointments for doctor " + (i + 1));
            int maxAppointments = Integer.parseInt(sc.nextLine());
            doctorQueues.add(new BoundedPriorityQueue(maxAppointments, doctorName));
        }
        System.out.println("Use From File ? Y/N");
        if(sc.nextLine().equalsIgnoreCase("Y")){
            patients = FileOperators.readAppointmentsFromBinFile("patients.bin");
        }

        displayPatients();
    }
    /**
     * Method to display the menu
     */
    private static void menu() {
        boolean running = true;
        while (running) {
            menuDisplay();

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    deletePatient();
                    break;
                case 3:
                    displayPatients();
                    break;
                case 4:
                    createAppointment();
                    break;
                case 5:
                    displayNextAppointmentForDoctor();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting system...");
                    FileOperators.savePatientsToBinFile(patients, "patients.bin");
                    break;
                default:
                    System.out.println("Invalid choice, please enter a number between 1 and 6.");
            }
        }

    }

    private static void menuDisplay() {
        System.out.println("/nChoose your option");
        System.out.println("1. Add a new patient");
        System.out.println("2.Delete patient info");
        System.out.println("3.Display patients details");
        System.out.println("4. Make an appointment");
        System.out.println("5 Display Appointments");
        System.out.println("6. exit");
    }/**
     * Method to display the doctors
     */
    private static void displayDoctors() {
        System.out.print("Doctors Ava: ");
        for (BoundedPriorityQueue doctorQueue : doctorQueues) {
            System.out.print(doctorQueue.getDoctorsName()+"|");
        }
    }/**
     * Method to add a patient
     */
    private static void addPatient() {
        Patient patient;
        System.out.println("Enter the first name of the patient");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name of the patient");
        String lastName = sc.nextLine();
        System.out.println("Enter the date of birth of the patient YYYY-MM-DD");
        String dob = sc.nextLine();

        try {
            LocalDate dateOfBirth = LocalDate.parse(dob);
            patient = new Patient(firstName, lastName, dateOfBirth);
            patients.add(patient);
            System.out.println("Patient added successfully");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
        }
    }
    /**
     * Method to delete a patient
     */
    private static void deletePatient() {
        System.out.println("Enter the first name of the patient you want to delete");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name of the patient you want to delete");
        String lastName = sc.nextLine();
        System.out.println("Enter the date of birth of the patient YYYY-MM-DD");
        String dob = sc.nextLine();
        Patient patient = findPatient(new Patient(firstName, lastName, LocalDate.parse(dob)));
        if (patient != null) {
            // Delete appointment where patient name is same as on appointment
            for (BoundedPriorityQueue doctorQueue : doctorQueues) {
                boolean removed = false;
                while(removed){
                    if(doctorQueue.remove(patient.getAppointments().get(doctorQueue.getDoctorsName()))){
                        removed = true;
                        System.out.println("Appointment deleted successfully");
                    }else{
                        removed = false;
                    }
                }
            }
            patients.remove(patient);
            System.out.println("Patient deleted successfully");

        } else {
            System.out.println("Patient not found");
        }

    }
    /**
     * Method to display the patients
     */
    private static void displayPatients() {
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
    }
    private static Patient findPatient(Patient patient) {
        for (Patient p : patients) {
            if (p.equals(patient)) {
                return p;
            }
        }
        return null;
    }
    /**
     * Method to create an appointment
     */
    private static void createAppointment() {
        displayDoctors();
        System.out.println("Enter the name of the doctor you want to make an appointment with");
        String doctorName = sc.nextLine();

        BoundedPriorityQueue doctorQueue = findDoctorQueue(doctorName);

        if (doctorQueue == null) {
            System.out.println("Doctor not found");
            return;
        }
        System.out.println("Enter the first name of the patient");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name of the patient");
        String lastName = sc.nextLine();
        System.out.println("Enter the date of birth of the patient YYYY-MM-DD");
        String dob = sc.nextLine();
        Patient patient = null;
        //check if patient already exists
        patient = findPatient(new Patient(firstName, lastName, LocalDate.parse(dob)));

        if (patient != null) {
            System.out.println("Patient already exists");
            return;
        }
        System.out.println("Enter the date of the appointment YYYY-MM-DD");
        String appointmentDate = sc.nextLine();
        System.out.println("Enter the issue");
        String issue = sc.nextLine();

        //random triage
        int triage = random.nextInt(5) + 1;

        // Add appointment to doctor's queue
        try {
            doctorQueue.safeAdd(new Appointment(firstName, lastName, LocalDate.parse(dob), issue, LocalDate.parse(appointmentDate), triage, doctorName));
            System.out.println("Appointment noted to doctor's queue ");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        patient.addAppointment(new Appointment(firstName, lastName, LocalDate.parse(dob), issue, LocalDate.parse(appointmentDate),triage,doctorName));
        System.out.println("Appointment created successfully");
    }
    /**
     * Method to find a doctor queue
     * @param doctorName The name of the doctor to find the queue for.
     * @return The doctor queue, or null if not found.
     */
    private static BoundedPriorityQueue findDoctorQueue(String doctorName) {
        BoundedPriorityQueue doctorQueueFound = null;
        for (BoundedPriorityQueue doctorQueue : doctorQueues) {
            if (doctorQueue.getDoctorsName().equalsIgnoreCase(doctorName)) {
                doctorQueueFound = doctorQueue;
            }

        }
        System.out.println("Doctor not found");
        return doctorQueueFound;
    }
    /**
     * Method to display the next appointment for a doctor
     */
    private static void displayNextAppointmentForDoctor() {
        displayDoctors();
        System.out.println("Enter the name of the doctor you want to display the next appointment for");
        String doctorName = sc.nextLine();

        BoundedPriorityQueue doctorQueue = findDoctorQueue(doctorName);

        if (doctorQueue == null) {
            System.out.println("Doctor not found");
            return;
        }
        try {
            Appointment nextAppointment = doctorQueue.peek();
            if (nextAppointment != null) {
                System.out.println("Next appointment for " + doctorName + ":");
                System.out.println(nextAppointment.toString());
            } else {
                System.out.println("No appointments found for " + doctorName);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
