package br.com.zup.challenge.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.challenge.three.controller.FileMapController;

@SpringBootApplication
public class AppChallengeThree implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppChallengeThree.class, args);
	}

	@Autowired
	private FileMapController fileMapController;

	@Override
	public void run(String... args) throws Exception {
		fileMapController.run(args);
	}
}
