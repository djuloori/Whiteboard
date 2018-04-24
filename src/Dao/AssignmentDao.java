package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.*;
import java.util.List;
import Model.AssignmentEO;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class AssignmentDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public String addAssignment(String assignment_id, String total_points, String assignment_name, InputStream test, String class_id)throws IOException {
        AssignmentEO assignmentEntity = new AssignmentEO();
        assignmentEntity.setAssignmentId(assignment_id);
        assignmentEntity.setAssignmentName(assignment_name);
        assignmentEntity.setTotalPoints(total_points);
        assignmentEntity.setAssignment(IOUtils.toByteArray(test));
        assignmentEntity.setCLASS_ID(class_id);
        em.getTransaction().begin();
        em.persist(assignmentEntity);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
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

    public String editAssignment(String assignmentid, String assignment_name, String total_points, InputStream test2,String classid) throws IOException {
        AssignmentEO assignmentEntity1 = new AssignmentEO();
        assignmentEntity1.setAssignmentId(assignmentid);
        assignmentEntity1.setAssignmentName(assignment_name);
        assignmentEntity1.setAssignment(IOUtils.toByteArray(test2));
        assignmentEntity1.setCLASS_ID(classid);
        assignmentEntity1.setTotalPoints(total_points);
        em.getTransaction().begin();
        em.merge(assignmentEntity1);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
            return "Editing Successful";
        } catch (Exception e) {
            return "Not Successful";
        }
    }

    public String removeAssignment(String assignment_id){
        em.getTransaction().begin();
        AssignmentEO ae = em.find(AssignmentEO.class,assignment_id);
        em.remove(ae);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
