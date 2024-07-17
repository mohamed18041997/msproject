package ClassRoom.service;

import ClassRoom.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface ClassRoomService {
    List<ClassRoom> findAll();
    Optional<ClassRoom> findById(String id);
    ClassRoom save(ClassRoom classRoom);
    void deleteById(String id);
}
