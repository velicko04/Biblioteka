package resource;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Autor;
import repository.AutorService;
import jakarta.inject.Inject;
import java.util.List;

@Path("/autor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AutorResource {

    @Inject
    AutorService autorService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
 	@Path("/addAutor")
    public Response addAutor(Autor autor) {
        autorService.addAutor(autor);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Autor> getAll() {
        return autorService.getAll();
    }
    
   
    }
