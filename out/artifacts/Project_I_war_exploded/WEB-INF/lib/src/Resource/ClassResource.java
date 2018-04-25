package Resource;

import Dao.ClassesDao;
import Rest.ClassesRO;
import Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("Classes")
public class ClassResource {

    @Autowired
    private ClassService classService;

    @POST
    @Path("/AddClass/{Classid}/{ClassName}/{Username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response RegisterClass(ClassesRO classesRO){
       String result = classService.syncClass(classesRO);
       if(result.equals("Success")){
           return Response.ok().build();
       }else{
           return Response.status(400).build();
       }
    }

   @PUT
   @Path("/UpdateClass/{Classid}/{ClassName}/{Username}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response UpdateClass(ClassesRO classesRO){
       String result = classService.modifyClass(classesRO);
       if(result.equals("Success")){
           return Response.ok().build();
       }else{
           return Response.status(400).build();
       }
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
        String result = classService.removeClass(Classid);
        if(result.equals("Success")){
            return Response.ok().build();
        }else{
            return Response.status(400).build();
        }
   }


}
