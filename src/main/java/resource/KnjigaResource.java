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
import model.Clan;
import model.Knjiga;
import repository.KnjigaService;

@Path("/knjiga")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KnjigaResource {

	@Inject
	KnjigaService knjigaService;
	
	@POST
	 @Consumes(MediaType.APPLICATION_JSON)
 	@Path("/addKnjiga")
    public Response addKnjiga(Knjiga knjiga) {
        knjigaService.addKnjiga(knjiga);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Knjiga> getAll() {
        return knjigaService.getAll();
    }
    
    @GET
 	@Produces(MediaType.APPLICATION_JSON)
 	@Path("getAllKnjige")
 	public Response getAllKnjige () {
 		List<Knjiga> knjige = knjigaService.getAll();
 		
 		return Response.ok().entity(knjige).build();
 	}
}
