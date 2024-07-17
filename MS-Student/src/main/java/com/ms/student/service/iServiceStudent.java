package com.ms.student.service;

import com.ms.student.dto.StudentDTO;
import com.ms.student.model.Student;

import java.util.List;

public interface iServiceStudent {
    public Student saveStudent(Student student);
    public Student getStudentById(long id);
    public List<Student> getAllStudents();
    public Student updateStudent(long id, Student student);
    public void deleteStudent(long id);
    StudentDTO getStudentWithClassRoomInfo(long id);

}
