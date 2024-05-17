package com.example.aicompletiondemo;

import java.util.Collections;
import java.util.List;

import org.springframework.ai.client.AiClient;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.messages.Message;
import org.springframework.ai.prompt.messages.MessageType;
import org.springframework.ai.prompt.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiCompletionApplication implements CommandLineRunner {
	private static final String ROLE_INFO_KEY = "role";

	@Autowired
	private AiClient aiClient;

	public static void main(String[] args) {
		SpringApplication.run(AiCompletionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, AI Completion!");
		System.out.println(String.format("Sending completion prompt to AI service. One moment please...\r\n"));

		final List<Message> msgs = Collections.singletonList(new UserMessage("When was Microsoft founded?"));

		final var resps = aiClient.generate(new Prompt(msgs));

		System.out.println(String.format("Prompt created %d generated response(s).", resps.getGenerations().size()));

		resps.getGenerations().stream()
				.forEach(gen -> {
					final var role = gen.getInfo().getOrDefault(ROLE_INFO_KEY, MessageType.ASSISTANT.getValue());

					System.out.println(String.format("Generated respose from \"%s\": %s", role, gen.getText()));
				});
	}

}
