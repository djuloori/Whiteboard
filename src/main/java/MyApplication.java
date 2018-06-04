import com.github.djuloori.whiteboard.dao.ClassesDao;
import com.github.djuloori.whiteboard.model.ClassesEO;
import com.github.djuloori.whiteboard.rest.ClassesRO;

public class MyApplication {

    //Used this class to run the methods locally.
    public static void main(String[] args){
        ClassesDao classesDao = new ClassesDao();
        ClassesRO classesRO = new ClassesRO();
        classesRO.setClassId("1");
        classesDao.removeClass(classesRO);
    }

}
