package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.AssignmentDao;
import com.github.djuloori.whiteboard.rest.AssignmentRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class AssignmentService {

   @Autowired
   private AssignmentDao assignmentDao;

   @Autowired
   private AssignmentRO assignmentRO;

   //ToDo - Make Use of RO's

   public String syncAssignment(String assignment_id, String total_points, String assignment_name, InputStream test, String class_id) throws IOException {
      return assignmentDao.addAssignment(assignment_id,total_points,assignment_name,test,class_id);
   }

   public String modifyAssignment(String assignment_id, String total_points, String assignment_name, InputStream test, String class_id) throws IOException{
      return assignmentDao.editAssignment(assignment_id,total_points,assignment_name,test,class_id);
   }

   public String removeAssignment(String Assignmentid){
      assignmentRO.setAssignmentId(Assignmentid);
      return assignmentDao.removeAssignment(Assignmentid);
   }


}
