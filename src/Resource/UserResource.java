package Resource;

import Dao.UserDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("Users")
public class UserResource  {
     UserDao userDao = new UserDao();

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("id") String id){
        return  "Dhruva" + " " + id;
    }

    @GET
    @Path("login/{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@PathParam("username") String username, @PathParam("password") String password){
        return userDao.findUser(username,password);
    }

    @POST
    @Path("register/{username}/{password}/{usertype}")
    @Produces(MediaType.TEXT_PLAIN)
    public String register(@PathParam("username") String username, @PathParam("password") String password, @PathParam("usertype") String usertype){
        return userDao.createUser(username,password,usertype);
    }
}
