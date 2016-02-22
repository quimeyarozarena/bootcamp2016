package model;

public class Course {

    private int idcourse;
    private String name;
    private Teacher teacher;
    private String hours;

    public Course() {
        // TODO Auto-generated constructor stub
    }

    public Course(int idcourse, String name, Teacher teacher, String hours) {
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

}
