package Business;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
* Applications for the Hospital to roster doctors
* @author Aloy And Joyal
* @version 1.0
* */
public class App {
    private static ArrayList Doctors = new ArrayList<>();
    private static ArrayList Ptients = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();


    private static void menu() {
boolean running = true;
while (running){
    System.out.println("/nChoose your option");
    System.out.println("1. Add a new patient");
    System.out.println("2.Delete patient info");
    System.out.println("3.Display patients details");
    System.out.println("4. Make an appointment");
    System.out.println("5 Display Appointments");
    System.out.println("6. exit");

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
            displayAppointments();
            break;
        case 6:
            running = false;
            System.out.println("Exiting system...");
            break;
        default:
            System.out.println("Invalid choice, please enter a number between 1 and 6.");
    }
}
    }

    private static void addPatient() {

    }

    private static void deletePatient() {

    }

    private static void displayPatients() {

    }

    private static void createAppointment() {

    }

    private static void displayAppointments() {

    }


}

