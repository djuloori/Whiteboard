package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.model.StudentEO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
public class StudentDao extends AbstractDao{

    @Transactional
    public List getAllStudents(){
        Query query = createQuery("StudentEntity.findAll", StudentEO.class);
        List<StudentEO> studentList = query.getResultList();
        return studentList;
    }
}