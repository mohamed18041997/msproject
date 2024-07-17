package ClassRoom.repository;

import ClassRoom.model.ClassRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRoomRepository extends MongoRepository<ClassRoom, String> {
}
