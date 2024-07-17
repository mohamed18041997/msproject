package com.ms.student.service;

import com.ms.student.dto.ClassRoomDTO;
import com.ms.student.dto.StudentDTO;
import com.ms.student.model.Student;
import com.ms.student.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class iServiceStudentImpl implements iServiceStudent {

    private final StudentRepo studentRepository;
    private final ClassRoomService classRoomService;

    public iServiceStudentImpl(StudentRepo studentRepository, ClassRoomService classRoomService) {
        this.studentRepository = studentRepository;
        this.classRoomService = classRoomService;
    }


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + student.getId()));
        existingStudent.setName(student.getName());
        existingStudent.setNote(student.getNote());
        // Update other fields as necessary
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO getStudentWithClassRoomInfo(long id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            ClassRoomDTO classRoomDTO = classRoomService.getClassByID(student.getClassRoomId());
            StudentDTO responseDTO = new StudentDTO();
            responseDTO.setName(student.getName());
            responseDTO.setNote(student.getNote());

            responseDTO.setClassRoomId(String.valueOf(classRoomDTO.getId()));
            return responseDTO;
        } else {
            return null; // or throw an exception
        }    }





}
