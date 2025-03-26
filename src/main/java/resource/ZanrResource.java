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
import model.Zanr;
import repository.ZanrService;

@Path("/zanr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZanrResource {

	@Inject
	ZanrService zanrService;
	
	@POST
	 @Consumes(MediaType.APPLICATION_JSON)
 	@Path("/addZanr")
    public Response addZanr(Zanr zanr) {
        zanrService.addZanr(zanr);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Zanr> getAll() {
        return zanrService.getAll();
    }
}
