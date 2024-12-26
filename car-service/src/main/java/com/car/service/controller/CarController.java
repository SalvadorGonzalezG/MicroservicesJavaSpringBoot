package com.car.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.service.entities.Car;
import com.car.service.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	// inyectamos un servicio
	@Autowired
	private CarService carrService;
	// Anotacion para mapear solicitudes HTTP
	@GetMapping
	public ResponseEntity<List<Car>> listsCars(){
		List<Car> car = carrService.getAll();
		if(car.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		//En caso contrario que mande una respuesta HTTP 200 CON EL CONTENIDO
		return ResponseEntity.ok(car);
	}
	// metodo para obtener un carro por id
	@GetMapping("/id")
	public ResponseEntity<Car> obtenerCar(@PathVariable("id") int id){
		//Llamamos al servicio para obtener el carro por id
		Car car = carrService.getCarById(id); 
		if(car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}

	// Metodo para guardar un carro
	@PostMapping
	public ResponseEntity<Car> saveCar(@RequestBody Car car){
		Car newCar = carrService.save(car);
		return ResponseEntity.ok(newCar);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Car>> listCarPerUserId(@PathVariable("userId") int id){
		List<Car> cars = carrService.byUserId(id);
		if(cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}
	
	
	
	
}


