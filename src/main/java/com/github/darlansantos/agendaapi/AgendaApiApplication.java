package com.github.darlansantos.agendaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.darlansantos.agendaapi.domain.Contato;
import com.github.darlansantos.agendaapi.repository.ContatoRepository;

@SpringBootApplication
public class AgendaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(
			@Autowired ContatoRepository contatoRepository) {
		return args -> {
			Contato contato = new Contato();
			contato.setNome("Darlan");
			contato.setEmail("darlanparreiras@gmail.com");
			contato.setFavorito(false);
			contatoRepository.save(contato);						
		};
	}
	
}
