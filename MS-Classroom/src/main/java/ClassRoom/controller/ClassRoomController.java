package ClassRoom.controller;

import ClassRoom.model.ClassRoom;
import ClassRoom.service.ClassRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassRoomController {


    private final ClassRoomService classRoomService;
    public ClassRoomController(ClassRoomService classRoomService){
        this.classRoomService = classRoomService;
    }

    @GetMapping
    public List<ClassRoom> getAllStocks() {
        return classRoomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> getClassById(@PathVariable String id) {
        return classRoomService.findById(id)
                .map(classRoom -> ResponseEntity.ok().body(classRoom))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClassRoom createClass(@RequestBody ClassRoom classRoom) {
        return classRoomService.save(classRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassRoom> updateClass(@PathVariable String id, @RequestBody ClassRoom classRoomDetails) {
        return classRoomService.findById(id)
                .map(classRoom -> {
                    classRoom.setZone(classRoomDetails.getZone());
                    ClassRoom updatedClassRoom = classRoomService.save(classRoom);
                    return ResponseEntity.ok().body(updatedClassRoom);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClass(@PathVariable String id) {
        return classRoomService.findById(id)
                .map(classRoom -> {
                    classRoomService.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
