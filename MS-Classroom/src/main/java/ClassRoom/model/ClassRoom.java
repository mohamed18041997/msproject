package ClassRoom.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "classrooms")
public class ClassRoom {
    @Id
    private String id;
    private String zone;

    private String location;

    public String getId() {
        return id;
    }

    public String getZone() {
        return zone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}

