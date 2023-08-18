package org.poc.kafka.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public class Student {

    private UUID id;

    private int rollNumber;

    private String firstName;

    private String lastName;

    private Contact contact;

    private String className;

    private List<Score> scores;
}
