package resource.domaci4;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;

public class MultipartRequest {

    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private FileUpload file;

    @RestForm("name")
    @PartType(MediaType.TEXT_PLAIN)
    private String name;

    public FileUpload getFile() {
        return file;
    }

    public void setFile(FileUpload file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}