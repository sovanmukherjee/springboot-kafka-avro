package org.poc.kafka.service.impl;

import lombok.AllArgsConstructor;
import org.poc.kafka.api.model.Student;
import org.poc.kafka.mapper.StudentMapper;
import org.poc.kafka.producer.StudentProducer;
import org.poc.kafka.service.StudentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentProducer studentProducer;
    private final StudentMapper studentMapper;

    @Override
    public String process(final Student student) {
        return studentProducer.send(studentMapper.mapStudentApiDataToStudentAvroData(student));
    }
}
