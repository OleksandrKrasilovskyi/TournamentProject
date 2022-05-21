package com.example.TournamentProject;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
@AllArgsConstructor
public class TournamentProjectApplication {

    private final Console console;

    public static void main(String[] args) {
        SpringApplication.run(TournamentProjectApplication.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void runApp() throws IOException {
        console.startApp();
    }
}
