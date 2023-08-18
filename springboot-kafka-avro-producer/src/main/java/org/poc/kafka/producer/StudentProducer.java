package org.poc.kafka.producer;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.poc.kafka.avro.model.Student;
import org.poc.kafka.config.ConfigProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class StudentProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ConfigProperties configProperties;

    public String send(Student student) {
        kafkaTemplate.send(configProperties.getStudentTopic(), student.getId(), student);
        log.info(String.format("#### -> Producing message -> %s", new Gson().toJson(student)));
        return "success";
    }
}
