package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.model.ClassesEO;
import com.github.djuloori.whiteboard.rest.ClassesRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;


    @Transactional
    public String addClass(ClassesRO classesRO){
        try {
            ClassesEO course = new ClassesEO();
            course.setClassId(classesRO.getClassId());
            course.setClassName(classesRO.getClassName());
            course.setUsername(classesRO.getUserName());
            m_SecurableEntityManager.save(course);
            return "Inserted";
        }catch (Exception e){
            return "Not Inserted";
        }
    }

    @Transactional
    public List getAllCourses() {
        try {
            Query query = m_SecurableEntityManager.createQuery("ClassesEntity.findAll", ClassesEO.class);
            List<ClassesEO> courseList = query.getResultList();
            return courseList;
        } catch(Exception e){
           return new ArrayList<ClassesEO>();
        }
    }

    @Transactional
    public String editClass(ClassesRO classesRO) {
        try {
            ClassesEO course = new ClassesEO();
            course.setClassId(classesRO.getClassId());
            course.setClassName(classesRO.getClassName());
            course.setUsername(classesRO.getUserName());
            m_SecurableEntityManager.update(course);
            return "Edited";
        } catch (Exception e) {
            return "Not Edited";
        }
    }

    @Transactional
    public String removeClass(ClassesRO classesRO){
        try {
            m_SecurableEntityManager.delete(ClassesEO.class,classesRO.getClassId());
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
