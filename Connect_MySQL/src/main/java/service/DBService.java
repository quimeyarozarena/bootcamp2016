package service;

import java.util.List;
import model.Schedule;

public interface DBService {

    public List<Schedule> getScheduleByTeacher(String teacherName);

}
