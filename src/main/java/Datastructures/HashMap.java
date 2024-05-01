package Datastructures;
import HospitalObjects.Patient;
import java.util.LinkedList;

/**
 * A hash map implementation for storing patients.
 */
public class HashMap {
    // Use a LinkedList array for chaining
    private LinkedList<Entry>[] map;
    private int count;

    /**
     * Constructs an empty PatientHashMap with the default initial capacity.
     */
    public HashMap() {
        map = new LinkedList[103]; // Initialize the array of linked lists
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>(); // Initialize each linked list in the array
        }
        count = 0;
    }

    // Calculate the slot index using the hash code
    private int calcSlot(Patient key) {
        int slot = Math.abs(key.hashCode()) % map.length;
        return slot;
    }

    /**
     * Removes the patient with the specified key from this map, if present.
     *
     * @param key the key of the patient to be removed
     * @return the value associated with the specified key, or null if the key is not found
     */
    public Patient remove(Patient key) {
        int slot = calcSlot(key);
        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                map[slot].remove(entry);
                count--;
                return entry.value;
            }
        }
        return null;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    public Patient get(Patient key) {
        int slot = calcSlot(key);
        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced by the specified value.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with the specified key, or null if the key is not found
     */
    public Patient put(Patient key, Patient value) {
        int slot = calcSlot(key);
        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                Patient oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        map[slot].add(new Entry(key, value));
        count++;
        return null;
    }

    // Nested class for storing map entries
    private static class Entry {
        protected Patient key;
        protected Patient value;

        public Entry(Patient key, Patient value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Returns the number of entries in this map.
     *
     * @return the number of entries in this map
     */
    public int size() {
        return count;
    }
}
