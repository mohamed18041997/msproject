package com.ms.student.service;

import com.ms.article.dto.StockDto;
import com.ms.student.dto.ClassRoomDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClassRoomService {
    private final RestTemplate restTemplate;

    public ClassRoomService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String SERVICE_URL = "http://localhost:8080/classrooms/";

    public ClassRoomDTO getClassByID(String id) {
        return restTemplate.getForObject(SERVICE_URL + id, ClassRoomDTO.class);
    }
}
