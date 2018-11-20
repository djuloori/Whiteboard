package com.github.djuloori.whiteboard.dao;

import javax.persistence.*;
import java.io.*;
import java.util.List;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.model.AssignmentEO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AssignmentDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;

    @Transactional
    public String addAssignment(String assignmentId, String totalPoints, String assignmentName, InputStream test, String classId)throws IOException {
        try {
            AssignmentEO assignment = new AssignmentEO();
            assignment.setAssignmentId(assignmentId);
            assignment.setAssignmentName(assignmentName);
            assignment.setTotalPoints(totalPoints);
            assignment.setAssignment(IOUtils.toByteArray(test));
            assignment.setCLASS_ID(classId);
            m_SecurableEntityManager.save(assignment);
            return "Perfect";
        }catch (Exception e){
            return "Not Inserted";
        }
    }

    @Transactional
    public List getAllAssignments(){
        Query query = m_SecurableEntityManager.createQuery("AssignmentsEntity.findAll", AssignmentEO.class);;
        List<AssignmentEO> assignments = query.getResultList();
        return assignments;
    }

    @Transactional
    public String editAssignment(String assignmentId, String assignmentName, String totalPoints, InputStream stream, String classId) throws IOException {
        try {
            AssignmentEO assignment = new AssignmentEO();
            assignment.setAssignmentId(assignmentId);
            assignment.setAssignmentName(assignmentName);
            assignment.setAssignment(IOUtils.toByteArray(stream));
            assignment.setCLASS_ID(classId);
            assignment.setTotalPoints(totalPoints);
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
