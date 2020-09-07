package com.learnSpring.objectsclass;

import com.learnSpring.hibernateclasses.DateUtilFormatter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="student")
@Access(value= AccessType.FIELD)
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="date_time")
    private Date dateTime;
    @Column(name="email")
    private String email;

    public Student(){
      super();

    }
    public Student(String firstName, String lastName,Date dateTime, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateTime= dateTime;
        this.email = email;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        DateUtilFormatter dateUtilFormatter= new DateUtilFormatter();
        return "Current Student details: "+ id+ "\n"+ firstName+"\n"+ lastName+ "\n"+ email+ "\n"+
                dateUtilFormatter.dateStringFormatter(dateTime);
    }
}
