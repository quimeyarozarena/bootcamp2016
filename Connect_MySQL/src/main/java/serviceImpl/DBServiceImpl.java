package serviceImpl;

import db.Database_Connectivity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Schedule;
import model.Teacher;
import service.DBService;

public class DBServiceImpl implements DBService {

    private Database_Connectivity dc;
    private Statement statement;

    public DBServiceImpl() {

        dc = new Database_Connectivity();
        statement = dc.do_db_connection();
    }

    public List<Schedule> getScheduleByTeacher(String teacherName) {

        List<Schedule> schedules = new ArrayList<Schedule>();

        try {
            ResultSet rs = statement.executeQuery(
                    "select t.firstname, s.day, initime, endtime, c.name from schedules s inner join courses c on s.idcourse = c.idcourse inner join teachers t on t.idteacher = c.idteacher where t.firstname = '"
                            + teacherName + "'");

            Schedule schedule = new Schedule();
            Course course = new Course();
            Teacher teacher = new Teacher();
            while (rs.next()) {

                teacher.setFirstname(rs.getString(1));
                schedule.setDay(rs.getString(2));
                schedule.setInitime(rs.getTime(3));
                schedule.setEndtime(rs.getTime(4));
                course.setName(rs.getString(5));
                course.setTeacher(teacher);
                schedule.setCourse(course);
                schedules.add(schedule);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

}
