package Service;

import Dao.ClassesDao;
import Rest.ClassesRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassService {

    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private ClassesRO classesRO;

    public String syncClass(ClassesRO classesRO){
        return classesDao.addClass(classesRO);
    }

    public String modifyClass(ClassesRO classesRO){
        return classesDao.editClass(classesRO);
    }

    public List viewAllClasses(){
        return classesDao.getAllCourses();
    }

    public String removeClass(String Classid){
        classesRO.setClassId(Classid);
        return classesDao.removeClass(classesRO);
    }

}
