package Resource;

import Dao.UserDao;
import Rest.UserRO;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Users")
public class UserResource  {

    @Autowired
     private UserService userService;


    @GET
    @Path("login/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("username") String username, @PathParam("password") String password){
        String result = userService.evaluateUser(username,password);
        if(result.equals("success")){
            return Response.ok().build();
        }else {
            return Response.status(400).build();
        }
    }

    @POST
    @Path("register/{username}/{password}/{usertype}")
    @Produces(MediaType.APPLICATION_JSON)
    public String register(@PathParam("username") String username, @PathParam("password") String password, @PathParam("usertype") String usertype){
        return userService.syncUser(username,password,usertype);
    }

}
