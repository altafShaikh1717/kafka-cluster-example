package com.kafka.cluster.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.cluster.service.ProducerService;

@RestController
public class Test {

	@Autowired
	ProducerService producerService;

	@GetMapping("/sendMsg/{msg}")
	public String sendMsg(@PathVariable String msg) {
		producerService.sendMessage(msg);
		return "sent";
	}
}
