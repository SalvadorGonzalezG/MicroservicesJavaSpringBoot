package com.ticket.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.service.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	// Declaramos un metodo personalizado para buscar tickets asociados a un usiario especifico
	List<Ticket> findByUserId(int userId);

}
