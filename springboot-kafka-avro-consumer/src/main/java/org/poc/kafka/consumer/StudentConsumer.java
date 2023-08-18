package org.poc.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.poc.kafka.avro.model.Student;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.SameIntervalTopicReuseStrategy;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
@Slf4j
public class StudentConsumer {

    /**
     * if autoCreateTopics is false then create retry and dlt topic manually
     * dlt topic : sm-poc-avro-student-tp-dlt
     * retry topic : sm-poc-avro-student-tp-retry
     */
    @RetryableTopic(
            backoff = @Backoff(value = 6000),
            attempts = "4",
            autoCreateTopics = "false",
            retryTopicSuffix = "-retry",
            dltTopicSuffix = "-dlt",
            sameIntervalTopicReuseStrategy = SameIntervalTopicReuseStrategy.SINGLE_TOPIC,
            exclude = {NullPointerException.class}

    )
    @KafkaListener(topics = "${toipc.student}")
    public void consume(ConsumerRecord<String, Student> studentRecord, @Headers MessageHeaders headers) {
        log.info("### -> Header acquired: {}", headers);
        Acknowledgment ack = headers.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        log.info(String.format("#### -> Consumed message -> %s", studentRecord.value()));
        log.info("#### -> Key: {}", studentRecord.key());
        log.info("#### -> FirstName: {}", studentRecord.value().getFirstName());
        if (Objects.nonNull(ack)) ack.acknowledge();
    }

    @DltHandler
    public void dlt(Student data, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.error("Event from topic {}  is dead lettered - event:{}", topic, data);
    }
}
