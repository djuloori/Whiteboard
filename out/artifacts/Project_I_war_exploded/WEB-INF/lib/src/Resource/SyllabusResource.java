package Resource;

import Service.SyllabusService;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class SyllabusResource {

    @Autowired
    private SyllabusService syllabusService;

    @POST
    @Path("/AddSyllabus/{classid}/{inputstream}/{syllabusid}")
    @Consumes({MediaType.MULTIPART_FORM_DATA,MediaType.TEXT_PLAIN})
    public Response SaveSyllabus(@PathParam("classid") String classid, @FormDataParam("inputstream") InputStream inputStream, @PathParam("syllabusid") String syllabusid) throws IOException {
        String result = syllabusService.syncSyllabus(classid,inputStream,syllabusid);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/DeleteSyllabus/{syllabusid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteAssignment(@PathParam("syllabusid") String syllabusid){
        return Response.ok(syllabusService.removeSyllabus(syllabusid)).build();
    }


}
