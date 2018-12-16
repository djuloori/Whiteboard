package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.ClassesDao;
import com.github.djuloori.whiteboard.model.ClassesEO;
import com.github.djuloori.whiteboard.rest.ClassesRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassService {

    @Autowired
    private ClassesDao classesDao;

    public String syncClass(ClassesRO classesRO){
        ClassesEO course = new ClassesEO();
        course.setClassId(classesRO.getClassId());
        course.setClassName(classesRO.getClassName());
        course.setUsername(classesRO.getUserName());
        return classesDao.addClass(course);
    }

    public String modifyClass(ClassesRO classesRO){
        ClassesEO course = new ClassesEO();
        course.setClassId(classesRO.getClassId());
        course.setClassName(classesRO.getClassName());
        course.setUsername(classesRO.getUserName());
        return classesDao.editClass(course);
    }

    public List viewAllClasses(){
        List<ClassesEO> classList = classesDao.getAllCourses();
        List<ClassesRO> courseList = new ArrayList<>(classList.size());
        for(ClassesEO classesEO: classList){
            ClassesRO course = new ClassesRO();
            course.setClassId(classesEO.getClassId());
            course.setClassName(classesEO.getClassName());
            courseList.add(course);
        }
        return courseList;
    }

    public String removeClass(String Classid){
        ClassesEO course = new ClassesEO();
        course.setClassId(Classid);
        return classesDao.removeClass(course);
    }

}
