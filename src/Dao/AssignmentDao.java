package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.*;
import java.util.List;
import Models.AssignmentEntity;
import Models.ClassesEntity;
import org.apache.commons.io.IOUtils;

/**
 * Created by Dhruva Juloori on 11/26/2017.
 */
public class AssignmentDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit-1");
    EntityManager em = emf.createEntityManager();

    public String addAssignment(String assignment_id, String total_points, String assignment_name, InputStream test, String class_id)throws IOException {
        AssignmentEntity assignmentEntity = new AssignmentEntity();
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
        Query a_q = em.createNamedQuery("AssignmentsEntity.findAll", AssignmentEntity.class);;
        List<AssignmentEntity> ae;
        ae = a_q.getResultList();
        return ae;
    }

    public String editAssignment(String assignmentid, String assignment_name, String total_points, InputStream test2,String classid) throws IOException {
        AssignmentEntity assignmentEntity1 = new AssignmentEntity();
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
            return "Editing Succesful";
        } catch (Exception e) {
            return "Not Succesful";
        }
    }

    public String removeAssignment(String assignment_id){
        em.getTransaction().begin();
        AssignmentEntity ae = em.find(AssignmentEntity.class,assignment_id);
        em.remove(ae);
        try {
            em.getTransaction().commit();
            //System.out.println("Removed");
            em.close();
            emf.close();
            return "Removed";
        }catch (Exception e){
            //System.out.println("I am here!");
            return "Not Removed";
        }
    }
}
