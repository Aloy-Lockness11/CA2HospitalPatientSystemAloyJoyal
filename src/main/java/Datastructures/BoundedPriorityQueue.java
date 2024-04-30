package Datastructures;

import HospitalObjects.Appointment;

public class BoundedPriorityQueue extends LinkedList {

    private final int sizelimit;
    private final String DoctorsName;
    private LinkedList queue;
    public BoundedPriorityQueue(int sizeLimit,String DoctorsName){
        super();
        this.sizelimit=sizeLimit;
        this.DoctorsName = DoctorsName;
        this.queue= new LinkedList();
    }
    @Override
    public void addLast(Appointment appointment) {
        if (appointment.getDoctorFullName().equalsIgnoreCase(DoctorsName)) {
            System.out.println("please write doctors name correctly.");
            return;
        }

        if (size() >= sizelimit) {
            System.out.println("sorry,the slots are full");
            return;
        }

        super.addLast(appointment);

    }

}
