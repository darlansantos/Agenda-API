package com.github.darlansantos.agendaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner(
//			@Autowired ContatoRepository contatoRepository) {
//		return args -> {
//			Contato contato = new Contato();
//			contato.setNome("Darlan");
//			contato.setEmail("darlanparreiras@gmail.com");
//			contato.setFavorito(false);
//			contatoRepository.save(contato);						
//		};
//	}
	
}
