package com.maven.jee;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("crew")
public class AmongoussResource {

    @Inject
    private CrewDAO crewDAO;
    // private static List<CrewMember> crewMembers = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response listMembers() {

        return Response.ok(crewDAO.getAllCrew()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response getOne(@PathParam("name") String name) {
        return Response.ok(crewDAO.getOne(name)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/insert")
    public Response insertMember(CrewMember crewMember) {
        crewDAO.insertCrew(crewMember);
        return Response.ok().build();
    }

    @DELETE
    @Path("{/id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Integer id) {

		return Response.ok().build();
	}
}
