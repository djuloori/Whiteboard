package Resource;

import Rest.ClassesRO;
import Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Classes")
public class ClassResource {

    @Autowired
    private ClassService classService;

    @POST
    @Path("/AddClass")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response RegisterClass(ClassesRO classesRO){
       return Response.ok(classService.syncClass(classesRO)).build();

    }

   @PUT
   @Path("/UpdateClass")
   @Produces(MediaType.APPLICATION_JSON)
   public Response UpdateClass(ClassesRO classesRO){
       return Response.ok(classService.modifyClass(classesRO)).build();
   }

   /*@GET - Not Needed
   @Produces(MediaType.TEXT_PLAIN)
   public List ReadClass(){
        return classService.viewAllClasses();
   }*/

   @DELETE
   @Path("/DeleteClass/{Classid}")
   @Produces(MediaType.TEXT_PLAIN)
   public Response DeleteClass(@PathParam("Classid") String Classid){
        return Response.ok(classService.removeClass(Classid)).build();
   }


}
