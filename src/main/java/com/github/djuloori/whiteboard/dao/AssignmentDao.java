package com.github.djuloori.whiteboard.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.*;
import java.util.List;
import com.github.djuloori.whiteboard.model.AssignmentEO;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class AssignmentDao {

    //@Huh - Shouldn't do in this way [Change in the next tag]
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public String addAssignment(String assignmentId, String totalPoints, String assignmentName, InputStream test, String classId)throws IOException {
        try {
            AssignmentEO assignment = new AssignmentEO();
            assignment.setAssignmentId(assignmentId);
            assignment.setAssignmentName(assignmentName);
            assignment.setTotalPoints(totalPoints);
            assignment.setAssignment(IOUtils.toByteArray(test));
            assignment.setCLASS_ID(classId);
            em.getTransaction().begin();
            em.persist(assignment);
            em.getTransaction().commit();
            return "Perfect";
        }catch (Exception e){
            return "Not Inserted";
        }
    }

    public List getAllAssignments(){
        em.getTransaction().begin();
        Query a_q = em.createNamedQuery("AssignmentsEntity.findAll", AssignmentEO.class);;
        List<AssignmentEO> ae;
        ae = a_q.getResultList();
        return ae;
    }

    public String editAssignment(String assignmentId, String assignmentName, String totalPoints, InputStream stream, String classId) throws IOException {
        try {
            AssignmentEO assignment = new AssignmentEO();
            assignment.setAssignmentId(assignmentId);
            assignment.setAssignmentName(assignmentName);
            assignment.setAssignment(IOUtils.toByteArray(stream));
            assignment.setCLASS_ID(classId);
            assignment.setTotalPoints(totalPoints);
            em.getTransaction().begin();
            em.merge(assignment);
            em.getTransaction().commit();
            return "Editing Successful";
        } catch (Exception e) {
            return "Not Successful";
        }
    }

    public String removeAssignment(String assignmentId){
        try {
            em.getTransaction().begin();
            AssignmentEO assignment = em.find(AssignmentEO.class,assignmentId);
            em.remove(assignment);
            em.getTransaction().commit();
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
