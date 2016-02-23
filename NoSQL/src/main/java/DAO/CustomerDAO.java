package DAO;

import com.mongodb.MongoClient;
import model.Student_courses;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class CustomerDAO extends BasicDAO<Student_courses, String> {

    public CustomerDAO(Morphia morphia, MongoClient mongo, String dbName) {
        super(mongo, morphia, dbName);
    }
}
