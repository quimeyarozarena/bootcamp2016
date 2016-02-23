package model;

import java.sql.Time;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Schedules {

    @Id
    @Property("_id")
    private int idschedule;
    private String day;
    private Time initime;
    private Time endtime;

    @Embedded
    private Courses course;

    public Schedules() {
        // TODO Auto-generated constructor stub
    }

    public Schedules(int idschedule, String day, Time initime, Time endtime, Courses course) {
        this.idschedule = idschedule;
        this.day = day;
        this.initime = initime;
        this.endtime = endtime;
        this.course = course;
    }

    public int getIdschedule() {
        return idschedule;
    }

    public void setIdschedule(int idschedule) {
        this.idschedule = idschedule;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getInitime() {
        return initime;
    }

    public void setInitime(Time initime) {
        this.initime = initime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public String toString() {
        return day + " " + initime + " " + endtime + " " + course.getName() + " " + course.getTeacher().getFirstname();
    }

}
