package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.AssignmentDao;
import com.github.djuloori.whiteboard.model.AssignmentEO;
import com.github.djuloori.whiteboard.rest.AssignmentRO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class AssignmentService {

   @Autowired
   private AssignmentDao assignmentDao;

   public String syncAssignment(String assignmentId, String totalPoints, String assignmentName, InputStream stream, String classId) throws IOException {
      AssignmentEO assignment = new AssignmentEO();
      assignment.setAssignmentId(assignmentId);
      assignment.setAssignmentName(assignmentName);
      assignment.setTotalPoints(totalPoints);
      assignment.setAssignment(IOUtils.toByteArray(stream));
      assignment.setClassId(classId);
      return assignmentDao.addAssignment(assignment);
   }

   public String modifyAssignment(String assignmentId, String totalPoints, String assignmentName, InputStream stream, String classId) throws IOException{
      AssignmentEO assignment = new AssignmentEO();
      assignment.setAssignmentId(assignmentId);
      assignment.setAssignmentName(assignmentName);
      assignment.setAssignment(IOUtils.toByteArray(stream));
      assignment.setClassId(classId);
      assignment.setTotalPoints(totalPoints);
      return assignmentDao.editAssignment(assignment);
   }

   public String removeAssignment(String Assignmentid){
      return assignmentDao.removeAssignment(Assignmentid);
   }

}
