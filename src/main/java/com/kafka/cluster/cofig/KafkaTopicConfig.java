package com.kafka.cluster.cofig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myTopic() {
        // topic name, num partitions, replication factor
        return new NewTopic("my-topic", 3, (short) 2);
    }
}