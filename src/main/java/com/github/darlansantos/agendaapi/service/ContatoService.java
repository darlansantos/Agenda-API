package com.github.darlansantos.agendaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.darlansantos.agendaapi.domain.Contato;
import com.github.darlansantos.agendaapi.repository.ContatoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContatoService {
	
	private final ContatoRepository contatoRepository;
	
	public Contato save(Contato contato) {
		return contatoRepository.save(contato);
	}

	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}
	
	public Optional<Contato> findById(Integer id) {
		return Optional.of(contatoRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado")));
	}

	public void delete(Integer id) {
		contatoRepository
		.findById(id)
		.map(contato -> {
			contatoRepository.delete(contato);
			return Void.TYPE;
		})
		.orElseThrow((() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado")));
	}

	public void update(Integer id, Boolean favorito) {
		contatoRepository
		.findById(id)
		.map( contato -> {
			contato.setFavorito(favorito);
			return contatoRepository.save(contato);
		})
		.orElseThrow((() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado")));
	}
	
}
