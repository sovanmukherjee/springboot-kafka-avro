package org.poc.kafka.api.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.poc.kafka.api.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@OpenAPIDefinition(info = @Info(
        title = "Student API",
        version = "1.0.0",
        description = "Student service to test kafka with avro schema registry",
        contact = @Contact(
                name = "Sovan Mukherjee",
                email = "sovanm10@gmail.com")
))
@RequestMapping(value = "students", produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
public interface StudentControllerApi {

    @PostMapping
    default ResponseEntity<String> processStudentData(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
