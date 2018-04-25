package Resource;

import Dao.UserDao;
import Rest.UserRO;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

@Path("Users")
public class UserResource  {

    @Autowired
     private UserService userService;

    @Autowired
    private UserRO userRO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testUser(){
        userRO.setUsername("user");
        userRO.setPassword("root");
        String type = userService.evaluateUser(userRO);
        return Response.ok("Professor").build();
    }


    @GET
    @Path("login/{username}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserRO userRO){
        String result = userService.evaluateUser(userRO);
        if(result.equals("success")){
            //String sessionid = issueToken(username); - ToDO
            return Response.ok(userRO.getUsertype()).build();
        }else {
            return Response.status(400).build();
        }
    }


    @POST
    @Path("Signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(UserRO userRO){
        String result = userService.syncUser(userRO);
        if(result.equals("success")){
            return Response.ok().build();
        }else {
            return Response.status(400).build();
        }
    }


    //ToDo-Sessions
    /*private String issueToken(String username){
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        return token;
    }*/

}
