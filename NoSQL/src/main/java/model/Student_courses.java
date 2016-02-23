package model;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Student_courses {

    @Id
    @Property("_id")
    private int id;
    private int partial1;
    private int partial2;
    private int partial3;
    private int avgEnd;

    @Embedded
    private Courses courses;
    @Embedded
    private Students student;

    public Student_courses() {
    }

    public Student_courses(int id, int partial1, int partial2, int partial3, int avgEnd, Courses courses,
            Students student) {
        this.id = id;
        this.partial1 = partial1;
        this.partial2 = partial2;
        this.partial3 = partial3;
        this.avgEnd = avgEnd;
        this.courses = courses;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartial1() {
        return partial1;
    }

    public void setPartial1(int partial1) {
        this.partial1 = partial1;
    }

    public int getPartial2() {
        return partial2;
    }

    public void setPartial2(int partial2) {
        this.partial2 = partial2;
    }

    public int getPartial3() {
        return partial3;
    }

    public void setPartial3(int partial3) {
        this.partial3 = partial3;
    }

    public int getAvgEnd() {
        return avgEnd;
    }

    public void setAvgEnd(int avgEnd) {
        this.avgEnd = avgEnd;
    }

    public Courses getCourse() {
        return courses;
    }

    public void setCourse(Courses courses) {
        this.courses = courses;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public String toString() {
        return student.getNregistratio() + " " + student.getFirstname() + " " + student.getLastname() + " "
                + student.getDateofbirth();
    }
}
