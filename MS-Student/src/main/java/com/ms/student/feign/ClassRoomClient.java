package com.ms.student.feign;

import com.ms.student.dto.ClassRoomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "classroom-service", url = "http://localhost:8080/classrooms")
public interface ClassRoomClient {
    @GetMapping("/{id}")
    ClassRoomDTO getClassById(@PathVariable("id") String id);
}
