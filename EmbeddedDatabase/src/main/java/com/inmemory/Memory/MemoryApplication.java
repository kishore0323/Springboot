package com.inmemory.Memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemoryApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MemoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Student id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting 10006-> {}", repository.save(new Student(10006L,"Jack Ma", "A1234657")));

		logger.info("Inserting 10007-> {}", repository.save(new Student(10007L, "Elon Musk", "ST30256")));

		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
	}
}