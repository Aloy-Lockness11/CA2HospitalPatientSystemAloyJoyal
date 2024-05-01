package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import HospitalObjects.Patient;

public class FileOperators {
    /**
     * Saves the patient to a binary file
     *
     * @param patient  the patient to save
     * @param filename the name of the file to save the patient to
     */
    public static void savePatientsToBinFile(ArrayList<Patient> patient, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(patient);
            System.out.println("Patients saved to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the patient from a binary file
     *
     * @param filename the name of the file to read the patient from
     * @return the patient read from the file
     */
    public static ArrayList<Patient> readAppointmentsFromBinFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            ArrayList<Patient> patient = (ArrayList<Patient>) ois.readObject();
            System.out.println("Patient read from file: " + filename);
            return patient;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
