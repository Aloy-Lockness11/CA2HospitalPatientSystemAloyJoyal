package Datastructures;

import HospitalObjects.Appointment;


public class LinkedList {
    /**
     * Represents a node in the linked list.
     */
    private Node first;
    private  int numElelments;

     class Node {
        Appointment appointmentData;
        Node next;
         /**
          * Constructs a new node with the given appointment data.
          * @param appointmentData The appointment data for this node.
          */

        Node(Appointment appointmentData) {
            this.appointmentData = appointmentData;
            this.next = null;

        }
    }
    /**
     * Constructs an empty LinkedList.
     */
        public LinkedList(){
            this.first = null;
            this.numElelments=0;
    }
    /**
     * Checks if the linked list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty(){
        return first == null;
    }
    /**
     * Retrieves the appointment data with the specified  doctors name in the linked list.
     * @param DoctorName The name of the appointment data to retrieve.
     * @return The appointment data with the specified name, or null if not found.
     */
    public Appointment get(String DoctorName) {
        Node current = first;
        while (current != null) {
            if (current.appointmentData.getDoctorFullName().equalsIgnoreCase(DoctorName)){
                return current.appointmentData;
            }
            current = current.next;
        }
        return null;
    }
    /**
     * Returns the number of elements in the linked list.
     * @return The number of elements in the list.
     */
    public int size(){
        return numElelments;
    }

    /**
     * Adds an appointment to the end of the linked list.
     * @param appointmentData The appointment data to add.
     */
    public void addLast(Appointment appointmentData){
        Node newNode = new Node(appointmentData);

        if (isEmpty()){
            first = newNode;

        }
        else{
            Node current= first;
            while(current.next != null){
                current = current.next;
            }
            current.next=newNode;

        }
        numElelments++;
    }
    /**
     * Removes the appointment from the linked list.
     * @param data The appointment data to remove.
     * @return true if the appointment was removed, false if it was not found.
     */
    public boolean remove(Appointment data) {
        if (isEmpty()) return false;

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
            previous.next = current.next;
        }

       numElelments--;
        return true;
    }
    /**
     * Creates a copy of the current linked list.
     * @param list The linked list to clone.
     * @return A new LinkedList that is a shallow copy of the current list.
     */
    public LinkedList cloneList(LinkedList list){
        LinkedList newList = new LinkedList();
        Node current = first;
        while (current != null) {
            newList.addLast(current.appointmentData);
            current = current.next;
        }
        return newList;
    }
    /**
     * Prints the appointment data of each node in the linked list.
     */
    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.println(current.next);
            current = current.next;
        }
    }


}

