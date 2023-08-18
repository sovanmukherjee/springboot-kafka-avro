package org.poc.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ConfigProperties {

    @Value("${topic.student}")
    private String studentTopic;
}
