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
	
	// Metodo HTTP 
	@GetMapping("/id")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("/id") int id){
		Moto moto = motoService.getMotoById(id);
		if(moto == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(moto);
	}
	// Metodo para guardar un carro
	@PostMapping
	public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto){
		Moto newMoto = motoService.save(moto);
		return ResponseEntity.ok(newMoto);
	}
	
	//Metodo
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Moto>> ListMotoPerUserId(@PathVariable("userId") int id){
		List<Moto> moto = motoService.findByUserId(id);
		if(moto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(moto);
	}
	

	
	
	
	
	
	
}

