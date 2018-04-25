package Service;

import Dao.ScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;



}
