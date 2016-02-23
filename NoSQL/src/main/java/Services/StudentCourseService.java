package Services;

import DAO.CustomerDAO;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.List;
import model.Student_courses;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

public class StudentCourseService {

    private List<Student_courses> student_courses;
    private CustomerDAO customerDAO;
    private MongoClient mongo;
    private Morphia morphia;

    public StudentCourseService() {
        try {
            mongo = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        morphia = new Morphia();
        morphia.mapPackage("model");
        customerDAO = new CustomerDAO(morphia, mongo, "highschool");

    }

    public List<Student_courses> getStudentsByCourseAndNotes(String courseName) {

        try {

            Query<Student_courses> query = customerDAO.getDatastore().createQuery(Student_courses.class);
            query.and(query.criteria("courses.name").equal(courseName), query.criteria("partial1").greaterThan(4),
                    query.criteria("partial2").greaterThan(4), query.criteria("partial3").greaterThan(4),
                    query.criteria("avgEnd").greaterThan(4));

            student_courses = query.asList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student_courses;
    }

}
