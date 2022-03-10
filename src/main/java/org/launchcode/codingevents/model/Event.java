package org.launchcode.codingevents.model;

//import jdk.jfr.EventType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

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

    public Event(String name, EventCategory eventCategory) {
        this.name = name;
//        this.when = dateFormat.format(when);
//        this.where = where;
        this.eventCategory = eventCategory;
    }

    public Event() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
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

//    public int getId() { return id;}

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Event event = (Event) o;
//        return id == event.id;
//    }

//    @Override
//    public int hashCode() { return Objects.hash(id); }
}
