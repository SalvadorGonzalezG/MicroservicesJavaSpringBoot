package com.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.entities.User;


// Marcamos la interfaz como un component de Spring(capa de acceso a datos)
// Indicamos que esta interfaz es un repositorio lo que permite que Spring gestion EXCEPCIONES relacionadas con operaciones en la DB
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
