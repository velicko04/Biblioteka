package resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Clan;
import repository.ClanService;
import jakarta.inject.Inject;
import java.util.List;

@Path("/clan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClanResource {

    @Inject
    ClanService clanService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
 	@Path("/addClan")
    public Response addClan(Clan clan) {
        clanService.addClan(clan);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Clan> getAll() {
        return clanService.getAll();
    }
}
