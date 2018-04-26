package Resource;

import Dao.TaDao;
import Rest.TaRO;
import Service.TaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TaResource {

    @Autowired
    private TaService taService;

    @POST
    @Path("/AddTa")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AddTa(TaRO taRO){
        return Response.ok(taService.syncTa(taRO)).build();
    }

    @DELETE
    @Path("/DeleteTa/{Taid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteTa(@PathParam("Taid") String Taid){
        return Response.ok(taService.removeTa(Taid)).build();
    }

}
