package org.poc.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.poc.kafka.avro.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "contactBuilder", ignore = true)
    Student mapStudentApiDataToStudentAvroData(org.poc.kafka.api.model.Student student);
}
