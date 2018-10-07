package com.yc.kafkademo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author YC
 * @create 2018-10-07 18:48
 */
@Data
@Component
public class KafkaConfig {
    @Value("${spring.kafka.consumer.topic}")
    private String topic;
}
