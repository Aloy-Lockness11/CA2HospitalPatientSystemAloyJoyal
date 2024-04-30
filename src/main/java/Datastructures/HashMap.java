package Datastructures;
import java.util.LinkedList;
import HospitalObjects.Patient;

public class HashMap {
    private int size;
    private LinkedList<Patient>[] patientData;

    public HashMap(int size){
        this.size = size;
        patientData = new LinkedList[size];
        for (int i = 0; i < size; i++){
            patientData[i] = new LinkedList<Patient>();
        }
    }

    private int hashFunction(Patient key) {
        int slot = Math.abs(key.hashCode());
        slot = slot % size;
        return slot;
    }
    public void put(Patient key) {
        int index = hashFunction(key);
        LinkedList<Patient> list = patientData[index];

        for (Patient p : list) {
            if (p.equals(key)) {
                list.remove(p);
                list.add(key);
                return;
            }
        }

        list.add(key);
        size++;
    }

    public boolean contains(Patient key) {
        int index = hashFunction(key);
        LinkedList<Patient> list = patientData[index];
        return list.contains(key);
    }

    public boolean remove(Patient key) {
        int index = hashFunction(key);
        LinkedList<Patient> list = patientData[index];
        boolean wasRemoved = list.remove(key);
        if (wasRemoved) {
            size--;
        }
        return wasRemoved;
    }

    public int size() {
        return size;
    }
    public void hashDisplay(){
        for (int i = 0; i < size; i++) {
            System.out.println("Slot " + i + ": ");
            for (Patient p : patientData[i]) {
                System.out.println(p);
            }
        }
    }
}
