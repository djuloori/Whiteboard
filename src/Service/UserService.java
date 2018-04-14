package Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("Users")
public class UserService  {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUsers(){
        return "Dhruva";
    }
}
