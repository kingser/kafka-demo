package com.yc.kafkademo.reader;

import com.yc.kafkademo.model.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 描述:
 *
 * @author YC
 * @create 2018-10-07 15:29
 */
@Component
@Slf4j
public class KafkaReceiver {

    @Autowired
    private KafkaConfig kafkaConfig;

    @KafkaListener(topics = {"#{kafkaConfig.topic}"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("----------------- record ===========" + record);
            log.info("------------------ message =" + message);
        }

    }
}
