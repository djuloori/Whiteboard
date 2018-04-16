package Resource;

import Dao.UserDao;
import Rest.UserRO;
import Service.UserService;
import sun.security.util.Password;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Users")
public class UserResource  {
     UserService userService = new UserService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("id") String id){
        return  "Dhruva" + " " + id;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserRO testUser(){
        String type = userService.evaluateUser("user","root");
        UserRO u1 = new UserRO();
        u1.setUsertype(type);
        return u1;
    }

    @GET
    @Path("login/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(@PathParam("username") String username, @PathParam("password") String password){
        return userService.evaluateUser(username,password);
    }

    @POST
    @Path("register/{username}/{password}/{usertype}")
    @Produces(MediaType.APPLICATION_JSON)
    public String register(@PathParam("username") String username, @PathParam("password") String password, @PathParam("usertype") String usertype){
        return userService.syncUser(username,password,usertype);
    }

}
