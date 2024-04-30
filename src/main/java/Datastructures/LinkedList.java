package Datastructures;

import HospitalObjects.Appointment;
import org.w3c.dom.Node;

public class LinkedList {
    private Node first;
    private  int numElelments;

    private static class Node {
        Appointment appointmentData;
        Node next;

        Node(Appointment appointmentData) {
            this.appointmentData = appointmentData;
            this.next = null;

        }
    }
        public LinkedList(){
            this.first = null;
            this.numElelments=0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return numElelments;
    }

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

    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.println(current.next);
            current = current.next;
        }
    }


}

