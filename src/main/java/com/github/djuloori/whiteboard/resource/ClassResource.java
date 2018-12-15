package com.github.djuloori.whiteboard.resource;

import com.github.djuloori.whiteboard.rest.ClassesRO;
import com.github.djuloori.whiteboard.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("Classes")
public class ClassResource {

    @Autowired
    private ClassService classService;

    @POST
    @Path("/AddClass")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response RegisterClass(ClassesRO classesRO, @Context HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        classesRO.setUserName(username);
        return Response.ok(classService.syncClass(classesRO)).build();

    }

   @PUT
   @Path("/UpdateClass")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response UpdateClass(ClassesRO classesRO, @Context HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        classesRO.setUserName(username);
        return Response.ok(classService.modifyClass(classesRO)).build();
   }


   @GET
   @Path("/getCourses")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getCourses(){
        return Response.ok(classService.viewAllClasses()).build();
   }

   @DELETE
   @Path("/DeleteClass/{Classid}")
   @Produces(MediaType.TEXT_PLAIN)
   public Response DeleteClass(@PathParam("Classid") String Classid){
        return Response.ok(classService.removeClass(Classid)).build();
   }


}
