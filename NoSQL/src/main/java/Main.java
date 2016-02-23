
import Services.StudentCourseService;
import java.util.List;
import model.Student_courses;

public class Main {

    public static void main(String[] args) {

        StudentCourseService studentCourseService = new StudentCourseService();
        List<Student_courses> student_courses = studentCourseService.getStudentsByCourseAndNotes("test");
        for (Student_courses sc : student_courses) {
            System.out.println(sc);
        }
    }

}
