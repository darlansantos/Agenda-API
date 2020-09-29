package com.github.darlansantos.agendaapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.darlansantos.agendaapi.domain.Contato;
import com.github.darlansantos.agendaapi.service.ContatoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contatos")
public class ContatoController {
	
	private final ContatoService contatoService; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato save(@RequestBody Contato contato) {
		return contatoService.save(contato);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Contato> findAll() {
		return contatoService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Contato> findById(@PathVariable Integer id) {
		  Optional<Contato> contato = contatoService.findById(id);
		  return contato;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		contatoService.delete(id);
	}
	
	@PatchMapping("{id}/favorito")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Boolean favorito) {
		contatoService.update(id, favorito);
	}
	
}
