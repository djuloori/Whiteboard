package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.framework.SecurableEntityManagerImpl;
import com.github.djuloori.whiteboard.model.StudentEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
public class StudentDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;

    @Transactional
    public List getAllStudents(){
        Query query = m_SecurableEntityManager.createQuery("StudentEntity.findAll", StudentEO.class);
        List<StudentEO> studentList = query.getResultList();
        return studentList;
    }
}