package com.kafka.cluster.service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	   @KafkaListener(topics = "my-topic", groupId = "my-consumer-group")
	    public void consume(ConsumerRecord<String, String> record) {
	        String topic = record.topic();
	        int partition = record.partition();
	        long offset = record.offset();
	        String key = record.key();
	        String value = record.value();

	        // NOTE: Kafka does not expose broker.id directly in the record.
	        // But you can log the leader host (broker) from record.topicPartition().toString()
	        // Or fetch metadata using AdminClient for detailed broker info.
	        
	        System.out.printf("Consumed from Topic: %s | Partition: %d | Offset: %d | Key: %s | Value: %s%n",
	                topic, partition, offset, key, value);
	    }
}
