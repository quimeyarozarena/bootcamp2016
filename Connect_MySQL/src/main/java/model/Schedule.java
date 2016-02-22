package model;

import java.sql.Time;

public class Schedule {

    private int idschedule;
    private String day;
    private Time initime;
    private Time endtime;
    private Course course;

    public Schedule() {
        // TODO Auto-generated constructor stub
    }

    public Schedule(int idschedule, String day, Time initime, Time endtime, Course course) {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String toString() {
        return day + " " + initime + " " + endtime + " " + course.getName() + " " + course.getTeacher().getFirstname();
    }

}
