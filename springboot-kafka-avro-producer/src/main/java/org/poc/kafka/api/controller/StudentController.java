package org.poc.kafka.api.controller;

import lombok.RequiredArgsConstructor;
import org.poc.kafka.api.model.Student;
import org.poc.kafka.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentControllerApi {

    private final StudentService studentService;

    @Override
    public ResponseEntity<String> processStudentData(Student student) {
        return ResponseEntity.ok().body(studentService.process(student));
    }
}
