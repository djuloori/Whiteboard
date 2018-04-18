package Service;

import Dao.ClassesDao;
import Rest.ClassesRO;

import java.util.List;

public class ClassService {
    ClassesDao classesDao = new ClassesDao();

    ClassesRO classesRO = new ClassesRO();

    public String syncClass(String Classid,String ClassName,String Username){
        classesRO.setClassId(Classid);
        classesRO.setClassName(ClassName);
        classesRO.setUserName(Username);
        return classesDao.addClass(classesRO);
    }

    public String modifyClass(String Classid, String ClassName, String Username){
        classesRO.setClassId(Classid);
        classesRO.setClassName(ClassName);
        classesRO.setUserName(Username);
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
