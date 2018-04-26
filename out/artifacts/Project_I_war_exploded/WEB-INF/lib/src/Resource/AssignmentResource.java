package Resource;

import Service.AssignmentService;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class AssignmentResource {

    @Autowired
    private AssignmentService assignmentService;

     @POST
     @Path("/AddAssignment/{assignment_id}/{total_points}/{assignment_name}/{test}/{class_id}")
     @Consumes({MediaType.MULTIPART_FORM_DATA,MediaType.TEXT_PLAIN})
     public Response SaveAssignment(@PathParam("assignment_id") String assignment_id, @PathParam("total_points") String total_points, @PathParam("assignment_name") String assignment_name, @FormDataParam("test") InputStream test, @PathParam("class_id") String class_id) throws IOException{
         String result = assignmentService.syncAssignment(assignment_id,total_points,assignment_name,test,class_id);
         return Response.ok(result).build();
     }

    @PUT
    @Path("/EditAssignment/{assignment_id}/{total_points}/{assignment_name}/{test}/{class_id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response EditAssignment(@PathParam("assignment_id") String assignment_id, @PathParam("total_points") String total_points, @PathParam("assignment_name") String assignment_name, @FormDataParam("test") InputStream test, @PathParam("class_id") String class_id) throws IOException{
        String result = assignmentService.modifyAssignment(assignment_id,total_points,assignment_name,test,class_id);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/DeleteAssignment/{assignment_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteAssignment(@PathParam("assignment_id") String assignment_id){
        return Response.ok(assignmentService.removeAssignment(assignment_id)).build();
    }
}
