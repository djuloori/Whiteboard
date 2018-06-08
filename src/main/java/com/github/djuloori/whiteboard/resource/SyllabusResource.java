package com.github.djuloori.whiteboard.resource;

import com.github.djuloori.whiteboard.service.SyllabusService;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path("/Syllabus")
@MultipartConfig
public class SyllabusResource {

    @Autowired
    private SyllabusService syllabusService;

    @POST
    @Path("/AddSyllabus")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response SaveSyllabus(@FormDataParam("courseId") String classid, @FormDataParam("Assignment-doc") InputStream inputStream, @FormDataParam("idsyllabus") String syllabusid) throws IOException {
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
