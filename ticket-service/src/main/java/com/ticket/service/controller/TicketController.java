package com.ticket.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.service.entity.Ticket;
import com.ticket.service.service.TicketService;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
	
	// Inyeccion del servicio.
	@Autowired
	public TicketService ticketService;
	
	// Metodo HTTP GET para listar todos los tickets
	@GetMapping
	public ResponseEntity<List<Ticket>> listTicket(){
		List<Ticket> ticket = ticketService.getAll();
	// Verificamos si la lista de tickets esta vacia
		if(ticket.isEmpty()) {
	// Si esta vacia devuelve una respuesta 204 (no content).
			return ResponseEntity.noContent().build();
		}
	// En caso contrario devuelve un 200 ok con la lista de tickets
		return ResponseEntity.ok(ticket);
	}

	// Metodo HHTP get para obtener un ticket por su ID
	@GetMapping("/id")
	public ResponseEntity<Ticket> getTicketById(@PathVariable("/id") int id){
	// Llamr al serevicio para buscar al ticket por su id
		Ticket ticket = ticketService.getTicketById(id);
	// Verifica si se encuentro el ticker 
		if(ticket == null) {
	// De no encoentrarse devuelve una respuesta con un status 204 (no content)
			return ResponseEntity.noContent().build();
		}
	// En caso contrario devuelve una respuesta HTTP con un status 200 ok con el objeto
		return ResponseEntity.ok(ticket);
	}
	
	// Metodo HTTP POST para guardar un Ticket
	@GetMapping
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
	// Se llama al servicio para guardar un nuevo ticket en la DB
		Ticket newTicket = ticketService.save(ticket);
	// Devuelve una respuesta HTTP 200 ok con el ticket recien guardado en el cuerpo de la respuesta
		return ResponseEntity.ok(newTicket);
	}
	
	// Metodo HTTP GET para obtener una lista de tickets de un usuario especifico
	@RequestMapping("/user/{userId}")
	public ResponseEntity<List<Ticket>> ListTicketsForUserId(@PathVariable("/userId") int id){
		List<Ticket> ticket = ticketService.findByUserId(id);
	// Verificamos si la lista de tickets esta vadia
		if(ticket.isEmpty()) {
	// Si lo esta devolvemos una respuesta HTTP con un status 204 (no content) 
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ticket);
	}
	
	
	
	
	
	
	
}
