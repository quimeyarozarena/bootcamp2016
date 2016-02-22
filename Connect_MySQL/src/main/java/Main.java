import java.util.List;
import model.Schedule;
import service.DBService;
import serviceImpl.DBServiceImpl;

public class Main {

    public static void main(String[] args) {

        DBService dbController = new DBServiceImpl();
        List<Schedule> schedules = dbController.getScheduleByTeacher("Roberto");
        for (int x = 0; x < schedules.size(); x++) {
            System.out.println(schedules.get(x));
        }
    }

}
