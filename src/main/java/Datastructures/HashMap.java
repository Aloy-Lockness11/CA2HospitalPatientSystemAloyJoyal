package Datastructures;
import HospitalObjects.Patient;
import java.util.LinkedList;

public class HashMap {
    // Use a LinkedList array for chaining
    private LinkedList<Entry>[] map;
    private int count;

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

    // Remove a patient by key, using chaining
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

    // Get a patient's value by key, using chaining
    public Patient get(Patient key) {
        int slot = calcSlot(key);
        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // Put a patient in the map, using chaining
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

    // Get the number of entries in the map
    public int size() {
        return count;
    }
}
