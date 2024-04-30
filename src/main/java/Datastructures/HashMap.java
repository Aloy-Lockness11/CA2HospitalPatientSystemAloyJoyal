package Datastructures;
import java.util.LinkedList;
import HospitalObjects.Patient;

/**
 * The HashMap class represents a hash table data structure that stores key-value pairs.
 * It uses a hash function to compute an index where the key-value pair is stored.
 */
public class HashMap {
    private int size;
    private LinkedList<Patient>[] patientData;

    /**
     * Constructs a HashMap with the specified size.
     * @param size the size of the hash table
     */
    public HashMap(int size){
        this.size = size;
        patientData = new LinkedList[size];
        for (int i = 0; i < size; i++){
            patientData[i] = new LinkedList<Patient>();
        }
    }

    /**
     * Computes the hash value for the given key.
     * @param key the key to compute the hash value for
     * @return the hash value
     */
    private int hashFunction(Patient key) {
        int slot = Math.abs(key.hashCode());
        slot = slot % size;
        return slot;
    }

    /**
     * Adds a key-value pair to the hash table.
     * If the key already exists, it updates the value.
     * @param key the key to add or update
     */
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

    /**
     * Checks if the hash table contains the specified key.
     * @param key the key to check
     * @return true if the key is found, false otherwise
     */
    public boolean contains(Patient key) {
        int index = hashFunction(key);
        LinkedList<Patient> list = patientData[index];
        return list.contains(key);
    }

    /**
     * Removes the specified key from the hash table.
     * @param key the key to remove
     * @return true if the key was removed, false otherwise
     */
    public boolean remove(Patient key) {
        int index = hashFunction(key);
        LinkedList<Patient> list = patientData[index];
        boolean wasRemoved = list.remove(key);
        if (wasRemoved) {
            size--;
        }
        return wasRemoved;
    }

    /**
     * Returns the number of key-value pairs in the hash table.
     * @return the size of the hash table
     */
    public int size() {
        return size;
    }

    /**
     * Displays the contents of the hash table.
     */
    public void hashDisplay(){
        for (int i = 0; i < size; i++) {
            System.out.println("Slot " + i + ": ");
            for (Patient p : patientData[i]) {
                System.out.println(p);
            }
        }
    }
}
