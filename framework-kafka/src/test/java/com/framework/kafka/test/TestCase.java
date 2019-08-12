package com.framework.kafka.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestCase {

    @Test
    public void test() {

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 4096);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //org.apache.kafka.common.config.ConfigException: Missing required configuration "key.serializer" which has no default value
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        ProducerFactory<String, String> pf = new DefaultKafkaProducerFactory<String, String>(props);
        KafkaTemplate<String, String> template = new KafkaTemplate<>(pf);
        template.setProducerListener(new ProducerListener() {
            public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
                log.info("Message send success : " + producerRecord.toString());
            }

            @Override
            public void onError(ProducerRecord producerRecord, Exception exception) {
                log.info("Message send error : " + producerRecord.toString());
            }
        });

        template.send(new ProducerRecord<>("test", "hello world1"));
        template.flush();
    }
}
