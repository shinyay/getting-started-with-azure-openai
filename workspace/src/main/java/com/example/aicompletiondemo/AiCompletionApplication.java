package com.example.aicompletiondemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class AiCompletionApplication implements CommandLineRunner {

    @Value("${SPRING_AI_AZURE_OPENAI_API_KEY}")
    private String apiKey;

    @Value("${SPRING_AI_AZURE_OPENAI_ENDPOINT}")
    private String endpoint;

    @Value("${SPRING_AI_AZURE_OPENAI_MODEL}")
    private String model;

    public static void main(String[] args) {
        SpringApplication.run(AiCompletionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String question = "What is the capital of France?";
        String response = sendQuestionToAzureOpenAI(question);
        System.out.println("Response from Azure OpenAI: " + response);
    }

    private String sendQuestionToAzureOpenAI(String question) {
        WebClient webClient = WebClient.builder()
                .baseUrl(endpoint)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();

        String response = webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/models/" + model + "/completions").build())
                .bodyValue("{ \"prompt\": \"" + question + "\", \"max_tokens\": 5 }")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
