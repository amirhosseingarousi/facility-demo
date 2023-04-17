package ir.dotin.facilitiesdemo.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "private_customer")
public class PrivateCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "national_id")
    private String nationalID;

    @Column(name = "number")
    private String number;

    public PrivateCustomer() {
    }

    public PrivateCustomer(String firstName, String lastName, String fatherName, LocalDate dob, String nationalID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dob = dob;
        this.nationalID = nationalID;
    }

    public PrivateCustomer(int id, String firstName, String lastName, String fatherName, LocalDate dob, String nationalID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dob = dob;
        this.nationalID = nationalID;
    }

    public PrivateCustomer(int id, String firstName, String lastName, String fatherName, LocalDate dob, String nationalID, String number) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dob = dob;
        this.nationalID = nationalID;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
