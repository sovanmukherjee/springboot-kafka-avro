package org.poc.kafka.service;


import org.poc.kafka.api.model.Student;

public interface StudentService {
    String process(Student std);
}
