package Resource;

import Dao.ClassesDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Classes")
public class ClassResource {
    ClassesDao classesDao = new ClassesDao();

    @POST
    @Path("/AddClass/{Classid}/{ClassName}/{Username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String RegisterClass(@PathParam("Classid") String Classid, @PathParam("ClassName") String ClassName, @PathParam("Username") String Username){
       return classesDao.addClass(Classid,ClassName,Username);
    }

   @PUT
   @Path("/UpdateClass/{Classid}/{ClassName}/{Username}")
   @Produces(MediaType.TEXT_PLAIN)
   public String UpdateClass(@PathParam("Classid") String Classid, @PathParam("ClassName") String ClassName, @PathParam("Username") String Username){
       return classesDao.editClass(Classid,ClassName,Username);
   }

   @GET
   @Produces(MediaType.TEXT_PLAIN)
   public List ReadClass(){
        return classesDao.getAllCourses();
   }

   @DELETE
   @Path("/DeleteClass/{Classid}")
   @Produces(MediaType.TEXT_PLAIN)
   public String DeleteClass(@PathParam("Classid") String Classid){
        return classesDao.removeClass(Classid);
   }


}
