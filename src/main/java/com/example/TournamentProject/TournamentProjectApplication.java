package com.example.TournamentProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TournamentProjectApplication {

	@Autowired
	private Game game;

	public static void main(String[] args) {
		SpringApplication.run(TournamentProjectApplication.class, args);

	}

	@EventListener(ContextRefreshedEvent.class)
	public void bigBikeMethod() {
		game.createTournament();
	}
}
