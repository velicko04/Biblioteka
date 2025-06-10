package resource.domaci4;

import java.io.IOException;
import java.nio.file.Files;

import org.jboss.resteasy.reactive.MultipartForm;

import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.nio.file.Paths;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

@Path("/upload")
public class MultipartResource {

    @Inject
    EntityManager em;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public String uploadFile(@QueryParam("id") Long id, @MultipartForm MultipartRequest request) {
        
        Korisnik korisnik = em.find(Korisnik.class, id);
        if (korisnik == null) {
            return "Korisnik with id " + id + " not found.";
        }
        
        FileUpload fileUpload = request.getFile();
        String originalFileName = fileUpload.fileName();

        try {
        	java.nio.file.Path uploadsDir = Paths.get("uploads");
            if (!Files.exists(uploadsDir)) {
                Files.createDirectories(uploadsDir);
            }

            java.nio.file.Path filePath = uploadsDir.resolve(originalFileName);

            Files.copy(fileUpload.uploadedFile(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
        
            String relativePath = "uploads/" + originalFileName;
            korisnik.setFilePath(relativePath);
            em.merge(korisnik);

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save file: " + e.getMessage();
        }

        return "File saved: " + originalFileName + " for entity id: " + id;
    }
    
    @POST
    @Path("/createTestUser")
    @Transactional
    public String createTestUser() {
        Korisnik k = new Korisnik();
        k.setId(1L);
        k.setData("Test data");
        k.setFilePath(null);
        em.persist(k);
        return "Test korisnik kreiran sa id=1";
    }
    
    
    
    @GET
    @jakarta.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response getKorisnikWithFile(@QueryParam("id") Long id) {
        Korisnik korisnik = em.find(Korisnik.class, id);
        if (korisnik == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        String pathStr = korisnik.getFilePath();
        if (pathStr != null && !pathStr.isEmpty()) {
            try {
                java.nio.file.Path filePath = Paths.get(pathStr);
                byte[] content = Files.readAllBytes(filePath);
                korisnik.setFileContent(content);
            } catch (IOException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("Failed to read file: " + e.getMessage()).build();
            }
        }

        return Response.ok(korisnik).build();
    }
}
