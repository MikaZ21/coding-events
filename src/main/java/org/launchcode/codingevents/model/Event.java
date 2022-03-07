package org.launchcode.codingevents.model;

//import jdk.jfr.EventType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;
//    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    private EventType type;

//    @DateTimeFormat(pattern = "MM/dd/yyyy")
//    private String when;
//
//    @NotBlank(message = "Location must be provided.")
//    private String where;
////
//    @AssertTrue(message = "Registration is required at all times.")
//    private boolean registrationRequired;
//
//    private int numberOfAttendees;
//
//    @Positive(message = "Number of attendees must be one or more.")
//    public int getNumberOfAttendees() {
//        return numberOfAttendees;
//    }
//
//    public void setNumberOfAttendees(int numberOfAttendees) {
//        this.numberOfAttendees = numberOfAttendees;
//    }
//
//    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public Event(String name, String description, String contactEmail, EventType type) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
//        this.when = dateFormat.format(when);
//        this.where = where;
        this.type = type;
    }

    public Event() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    //    @NotEmpty(message = "Date must be provided.")
//    public String getWhen() {
////        if (when == null) {
////            when = new Date();
////        }
//        return when;
//    }
//
//    public void setWhen(Date when)  {
//        this.when = dateFormat.format(when);
//    }
//
//    public String getWhere() {
//        return where;
//    }
//
//    public void setWhere(String where) {
//        this.where = where;
//    }
//
//    public boolean isRegistrationRequired() {
//        return registrationRequired;
//    }
//
//    public void setRegistrationRequired(boolean registrationRequired) {
//        this.registrationRequired = registrationRequired;
//    }

    public int getId() { return id;}

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
