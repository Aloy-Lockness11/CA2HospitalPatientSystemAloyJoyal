package HospitalObjects;

import Datastructures.LinkedList;

import java.time.LocalDate;

public class Patient {

private String  firstName;
private String  secondName;
private LocalDate dateOfBirth;

private LocalDate joiningDate;


//private LinkedList<Appointment> appointments;


public Patient(String firstName, String secondName,
               LocalDate dateOfBirth, LocalDate joiningDate){

    this.firstName = firstName;
    this.secondName = secondName;
    this.dateOfBirth = dateOfBirth;
    this.joiningDate = joiningDate;
   // this.appointments = new LinkedList();
    }

    public String getFirstName(){
    return firstName;
    }
    public String getSecondName(){
    return secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }


   // public LinkedList<Appointment> getAppointments() {
    //    return appointments;
  //  }

    @Override
    public boolean equals(Object o){
    if (this == o){
        return true;
    }
    if (o == null|| getClass() != o.getClass() ){
        return false;
    }
    Patient patient= (Patient) o;

    return firstName.equals(patient.firstName)&& secondName.equals(patient.secondName) &&
            dateOfBirth.equals(patient.dateOfBirth);
    }
}
