package com.github.darlansantos.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.darlansantos.agendaapi.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
