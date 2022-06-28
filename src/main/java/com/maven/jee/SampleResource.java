package com.maven.jee;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("sample")
public class SampleResource {

	@Inject
	@ConfigProperty(name = "message")
	private String message;

	@GET
	public Response message() {
		return Response.ok(message).build();
	}
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/titans")
    public Response getTitans() {
        // src: https://attaque-des-titans.fandom.com/fr/wiki/Titans
        String titans[] = {"Titan Ahmedattor", "Titan Amine", "Titan Alex", "Titan julien", "Titan Mâchoire",
                "Titan Bestial",
                "Titan Charrette",
                "Titan Marteau d'Armes", "Titan Originel"};
        return Response.ok(titans).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/insertTitans")
    public Response testPost(TestJsonRessource testJsonRessource) {
        if (testJsonRessource.getName() == null){
            return Response.status(403).build();
        }
        return Response.ok("Posted " + testJsonRessource.getName() + ". Age: " + testJsonRessource.getAge()).build();
    }
}
