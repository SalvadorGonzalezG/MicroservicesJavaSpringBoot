package com.moto.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moto.service.entity.Moto;

// Indicamos que esta interfaz es un componente de Spring encargado de interactuar con la DB
// Anotacion que utilizamos para desiganar esta interfaz como repositorio de persistencia
@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer>{

	// Declaramos un metodo personalizado para busacar motos asociados a un usuario especifico
	List<Moto> findByUserId(int userId);
}