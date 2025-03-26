package resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Biblioteka;
import repository.BibliotekaService;

@Path("/biblioteka")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BibliotekaResource {

	 @Inject
	    BibliotekaService bibliotekaService;

	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	 	@Path("/addBiblioteka")
	    public Response addBiblioteka(Biblioteka biblioteka) {
	        bibliotekaService.addBiblioteka(biblioteka);
	        return Response.status(Response.Status.CREATED).build();
	    }

	    @GET
	    public List<Biblioteka> getAll() {
	        return bibliotekaService.getAll();
	    }
}
