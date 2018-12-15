package com.github.djuloori.whiteboard.resource;

import com.github.djuloori.whiteboard.service.AssignmentService;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path("/Assignment")
public class AssignmentResource {

    @Autowired
    private AssignmentService assignmentService;

     @POST
     @Path("/AddAssignment")
     @Consumes(MediaType.MULTIPART_FORM_DATA)
     public Response SaveAssignment(@FormDataParam("Assignment-ID") String assignment_id, @FormDataParam("Assignment-Name") String assignment_name,@FormDataParam("Total-Points") String total_points , @FormDataParam("Assignment-doc") InputStream inputStream, @FormDataParam("classid") String classid) throws IOException{
         String result = assignmentService.syncAssignment(assignment_id,total_points,assignment_name,inputStream,classid);
         return Response.ok(result).build();
     }

     @GET
     @Path("/GetAssignments")
     @Produces(MediaType.APPLICATION_JSON)
     public Response getAssignments(){
         return Response.ok(assignmentService.viewAllAssignments()).build();
     }


    @DELETE
    @Path("/DeleteAssignment/{assignment_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteAssignment(@PathParam("assignment_id") String assignment_id){
        return Response.ok(assignmentService.removeAssignment(assignment_id)).build();
    }
}
