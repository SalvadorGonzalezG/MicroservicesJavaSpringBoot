package com.ticket.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.service.entity.Ticket;
import com.ticket.service.repository.TicketRepository;

@Service
public class TicketService {
	//Inyectamos el repositorio
	@Autowired
	public TicketRepository ticketRepository;
	
	// Metodo para obtener todos los tickets
	public List<Ticket> getAll(){
		return  ticketRepository.findAll();
	}
	
	// Metodo para obtener un ticket por iD 
	public Ticket getTicketById(int id) {
	// Busca el Ticket por su ID usando el metodo findById del repositorio
		return ticketRepository.findById(id).orElse(null);
	}
	
	// Metodo para guardar un Ticket
	public Ticket save(Ticket ticket) {
		Ticket newTicket = ticketRepository.save(ticket);
		return newTicket;
	}
	
	// Metodo para obtener todos los tickets de un usuario
	public List<Ticket> findByUserId(int userId){
		return ticketRepository.findByUserId(userId);
	}
	
	
}
