package Datastructures;

import HospitalObjects.Appointment;

public class BoundedPriorityQueue extends LinkedList {
    private Node first;
    private final int sizelimit;
    private final String DoctorsName;
    private int currentSize = 0;

    /**
     * Constructs a new BoundedPriorityQueue with the specified size limit and doctor's name.
     *
     * @param sizeLimit   The maximum number of appointments in the queue.
     * @param DoctorsName The name of the doctor associated with the appointments.
     */
    public BoundedPriorityQueue(int sizeLimit,String DoctorsName) {

        this.first = null;
        this.sizelimit = sizeLimit;
        this.DoctorsName = DoctorsName.toLowerCase();
    }
    /**
     * Adds an appointment to the queue (fail-fast version).
     *
     * @param appointment The appointment to add.
     * @return true if the appointment was added successfully.
     * @throws IllegalArgumentException if the doctor names do not match.
     * @throws IllegalStateException    if the queue is full.
     */
    public boolean add(Appointment appointment) {
        if (!DoctorsName.equals(appointment.getDoctorFullName().toLowerCase())) {
            throw new IllegalArgumentException("Doctor names do not match.");
        }

        if (currentSize >= sizelimit) {
            throw new IllegalStateException("Queue is full.");
        }

        currentSize++;
        return true;
    }
/**
 * Adds an appointment to the queue (safe version).
 *
 * @param appointment The appointment to add.
 * @return true if the appointment was added successfully, false otherwise.
 */

    public boolean safeAdd(Appointment appointment) {
        try {
            return add(appointment);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Removes and returns the head of the queue (fail-fast version).
     *
     * @return The appointment at the head of the queue.
     * @throws IllegalArgumentException the queue is empty.
     */
    public Appointment remove() {
        if (first== null) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        Appointment data = first.appointmentData;
        first = first.next;
        currentSize--;
        return data;
    }

    /**
     * Removes and returns the head of the queue (safe version).
     *
     * @return The appointment at the head of the queue, or null if the queue is empty.
     */
    public Appointment safeRemove() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return remove();
    }
    public boolean removespec(Appointment data) {
        if (isEmpty())
            return false;
        Node current = first;
        Node previous = null;
        while (current != null && !current.appointmentData.equals(data)) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (previous == null) {
            first = first.next;
        } else {
            //
            previous.next = current.next;
        }
        currentSize--;
        return true;
    }
    public String getDoctorsName(){
        return DoctorsName;
    }





}


