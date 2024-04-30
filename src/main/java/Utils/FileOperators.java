package Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import HospitalObjects.Appointment;

public class FileOperators {
    public static void saveAppointmentsToBinFile(Appointment appointments, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(appointments);
            System.out.println("Appointments saved to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAppointmentsFromBinFile(String filename) {
        // TODO  Implement this method
    }

}