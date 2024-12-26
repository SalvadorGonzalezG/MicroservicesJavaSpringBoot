package com.car.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.service.entities.Car;
import com.car.service.repository.CarrRepository;

@Service
public class CarService {

	//inyectamos el repositorio
	@Autowired
	private CarrRepository carrRepository;
	
	// primer metodo similar al de userService
	public List<Car> getAll(){
		return carrRepository.findAll();
	}
	
	public Car getCarById(int id) {
		return carrRepository.findById(id).orElse(null);
	}
	
	public Car save(Car car) {
		Car newCar = carrRepository.save(car);
		return newCar;
	}
	
	// metodo que obtendra todos los carros de un usuario
	public List<Car> byUserId(int userId){
		return carrRepository.findByUser(userId);
	}
}