package resource;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.BibliotekaClan;
import repository.BibliotekaClanService;
import jakarta.inject.Inject;
import java.util.List;

@Path("/bibliotekaClan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BibliotekaClanResource {

    @Inject
    BibliotekaClanService bibliotekaClanService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
 	@Path("/addBibliotekaClan")
    public Response addBibliotekaClan(BibliotekaClan bibliotekaClan) {
        bibliotekaClanService.addBibliotekaClan(bibliotekaClan);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<BibliotekaClan> getAll() {
        return bibliotekaClanService.getAll();
    }
    }
