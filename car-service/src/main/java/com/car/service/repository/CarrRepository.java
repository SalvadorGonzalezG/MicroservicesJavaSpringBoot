package com.car.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.service.entities.Car;

// Indicamos que la interfaz es un componente de acceso a datos
// Permitiendo a Spring maneja excepciones especificas de la DB
@Repository
public interface CarrRepository extends JpaRepository<Car, Integer>{
	
// Método personalizado que busca una Lista de objetos 'Car' asociado a un usuario especifico
// por 'userId' Spring Data JPA genera automaticamnte la implementacion de este metodo
	List<Car> findByUser(int userId);
}
