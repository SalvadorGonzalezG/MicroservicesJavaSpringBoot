package com.moto.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entity.Moto;
import com.moto.service.service.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {

	@Autowired // Realizamos la inyeccion del servicio
	private MotoService motoService;
	
	// Meotod HTTP GET para listar todas las motos
	@GetMapping
	public ResponseEntity<List<Moto>> listMoto(){
	// Llama al servicio para obtener todas las motos
		List<Moto> moto = motoService.getAll();
	// Verifica si la lista de motos esta vacia
		if(moto.isEmpty()) {
	// Si no hay motos, devuelve una respuesta HTTP 204 (No Content)	
			return ResponseEntity.noContent().build();
		}
		// en caso contrario manda una respuesta HTTP con un status 200 y el contenido
		return ResponseEntity.ok(moto);
	}
	
	// Metodo HTTP GET para obtener una moto por su ID
	@GetMapping("/id")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("/id") int id){
	// LLama al servicio para buscar la moto por su ID
		Moto moto = motoService.getMotoById(id);
	// Verifica si se encontro la moto
		if(moto == null) {
	// Si no se encuentra devuelve una respuesta HTTP 204 (no content)
			return ResponseEntity.noContent().build();
		}
	// Si la moto fue encontrada, devuelve una respuesta HTTP 200 ok con el objeto moto
		return ResponseEntity.ok(moto);
	}
	// Metodo HTTP POST para guardar una moto
	@PostMapping
	public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto){
	// LLama al servicio para guardar la nueva moto en la DB
		Moto newMoto = motoService.save(moto);
	// Devuelve una respuesta HTTP 200 OK con la moto recien guardada en el cuerpo de la respuesta 
		return ResponseEntity.ok(newMoto);
	}
	
	// Metodo HTTP GET para obtener una lista de motos asociadas a un usuario especifico
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Moto>> ListMotoPerUserId(@PathVariable("userId") int id){
	// LLama al servicio para buscar las motos asociadas ak ID del usuario
		List<Moto> moto = motoService.findByUserId(id);
	// Verifica si la lista de motos esta vacia
		if(moto.isEmpty()) {
	// Si no hay motos asociadas, devuelve una Respuesta HTTP con el estado 204 (no content)
			return ResponseEntity.noContent().build();
		}
	// Si se encuentran motos, devuelve una respuesta HTTP con el estado 200 ok y la lista de motos
		return ResponseEntity.ok(moto);
	}	
}

