package HospitalObjects;

import Datastructures.LinkedList;

import java.time.LocalDate;

public class Patient {
    /**
     * the variables for the information of patient
     */
    private String  firstName;
private String  secondName;
private LocalDate dateOfBirth;

private LocalDate joiningDate;



    /**
     * adding new Patient with the specified names,
     * date of birth, and joining date.
     *
     * @param firstName    The first name of the patient.
     * @param secondName   The second name of the patient.
     * @param dateOfBirth  The date of birth of the patient.
     * @param joiningDate  The date when the patient joined.
     */
private LinkedList appointments;


public Patient(String firstName, String secondName,
               LocalDate dateOfBirth, LocalDate joiningDate){

    this.firstName = firstName;
    this.secondName = secondName;
    this.dateOfBirth = dateOfBirth;
    this.joiningDate = joiningDate;
   this.appointments = new LinkedList();
    }
    /**
     * Gets the first name of the patient.
     * @return The first name of the patient.
     */
    public String getFirstName(){
    return firstName;
    }
    /**
     * Gets the second name of the patient.
     * @return The second name of the patient.
     */
    public String getSecondName(){
    return secondName;
    }
    /**
     * Gets the date of birth of the patient.
     * @return The date of birth of the patient.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Gets the joining date of the patient.
     * @return The joining date of the patient.
     */
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
