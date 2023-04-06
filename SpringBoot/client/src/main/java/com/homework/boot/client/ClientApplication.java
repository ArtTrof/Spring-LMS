package com.homework.boot.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.boot.client.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    private final WebClient webClient;

    @Autowired
    public ClientApplication(WebClient webClient) {
        this.webClient = webClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:1010/emp";
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employees = mapper.readValue(new URL(url), new TypeReference<List<Employee>>() {});
        employees.stream().map(Employee::toString).forEach(System.out::println);
    }
}
