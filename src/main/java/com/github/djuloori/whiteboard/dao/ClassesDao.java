package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.model.ClassesEO;
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
    public String addClass(ClassesEO course){
        try {
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
    public String editClass(ClassesEO course) {
        try {
            m_SecurableEntityManager.update(course);
            return "Edited";
        } catch (Exception e) {
            return "Not Edited";
        }
    }

    @Transactional
    public String removeClass(ClassesEO course){
        try {
            m_SecurableEntityManager.delete(ClassesEO.class,course.getClassId());
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
