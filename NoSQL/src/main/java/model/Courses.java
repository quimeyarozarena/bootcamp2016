package model;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Courses {

    private int idcourse;
    private String name;

    @Embedded
    private Teachers teacher;
    private String hours;

    public Courses() {
        // TODO Auto-generated constructor stub
    }

    public Courses(int idcourse, String name, Teachers teacher, String hours) {
        super();
        this.idcourse = idcourse;
        this.name = name;
        this.teacher = teacher;
        this.hours = hours;
    }

    public int getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(int idcourse) {
        this.idcourse = idcourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

}
