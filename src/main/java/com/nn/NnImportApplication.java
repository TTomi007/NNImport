package com.nn;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.nn.service.ImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class NnImportApplication implements CommandLineRunner {

	private final ImportService importService;

	private static final Logger log = LoggerFactory.getLogger(NnImportApplication.class);

	public NnImportApplication(ImportService importService) {
		this.importService = importService;
	}


	public static void main(String[] args) {
		log.info("Started NN import application");
		SpringApplication.run(NnImportApplication.class, args);
		log.info("Finished NN import application");
	}

	@Override
	public void run(String... args) {
		IntStream.range(0, args.length).forEach( i -> log.info("args[{}]: {}", i, args[i]));

		Args argsObject = new Args();
		try {
			JCommander.newBuilder()
					.addObject(argsObject)
					.build()
					.parse(args);
			importService.importFromFiles(argsObject);
		} catch (ParameterException e) {
			log.error("Invalid parameter: {}", e.getMessage());
		}
	}
}
