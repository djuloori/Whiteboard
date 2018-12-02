package com.github.djuloori.whiteboard.dao;

import javax.persistence.*;
import java.io.*;
import java.util.List;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.model.AssignmentEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AssignmentDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;

    @Transactional
    public String addAssignment(AssignmentEO assignment)throws IOException {
        try {
            m_SecurableEntityManager.save(assignment);
            return "Perfect";
        }catch (Exception e){
            return "Not Inserted";
        }
    }

    @Transactional
    public List getAllAssignments(){
        Query query = m_SecurableEntityManager.createQuery("AssignmentsEntity.findAll", AssignmentEO.class);
        List<AssignmentEO> assignments = query.getResultList();
        return assignments;
    }

    @Transactional
    public String editAssignment(AssignmentEO assignment) throws IOException {
        try {
            m_SecurableEntityManager.update(assignment);
            return "Editing Successful";
        } catch (Exception e) {
            return "Not Successful";
        }
    }

    @Transactional
    public String removeAssignment(String assignmentId){
        try {
            m_SecurableEntityManager.delete(AssignmentEO.class,assignmentId);
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
