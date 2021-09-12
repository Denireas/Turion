package com.denireas.turion.services;

import com.denireas.turion.entity.Student;
import com.denireas.turion.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student getById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public void saveStudent(Student student) {
        if (student != null) studentRepository.save(student);
    }

    public void updateStudent(Long id, Student newStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(newStudent.getName());
            student.setSurname(newStudent.getSurname());
            student.setMiddleName(newStudent.getMiddleName());
            student.setBirthdate(newStudent.getBirthdate());
            student.setLevel(newStudent.getLevel());
            studentRepository.save(student);
        }
    }

    public void sayHello() {
        System.out.println("Hello!");
        System.out.println("Goodbye");
    }
}
