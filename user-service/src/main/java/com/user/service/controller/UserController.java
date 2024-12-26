package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.exceptions.UserNotFoundException;
import com.user.service.serv.UserService;

// Indicamos que est aclase es un controlador REST
// permite manejar solicitudes HTTP y devolver respuestas en formato JSON o similar
@RestController
// Especificamos la ruta base para todas las solicitudes que maneja este controlador
// Caso especidico "todas las rutas comenzaran con "/user"
@RequestMapping("/user")
public class UserController {

// inyeccion de depedencias UserService
// Permite usar los metodos de UserService sin necesidad de crear manualmente una instancia
	@Autowired
	private UserService userService;
	
// Anotacion para mapear solicitudes HTTP GET a este metodo.
	@GetMapping
	public ResponseEntity<List<User>> listUsers() {
// Llama al servicio para obtener todos los usuarios disponibles
		List<User> users = userService.getAll();
// Condicion que comprueba si la lista de usuarios esta vacia
		if(users.isEmpty()) {
// Si no hay usuarios, retornamos una respuesta HTTP 204(No Content)
			return ResponseEntity.noContent().build();
		}
// si hay usuarios, retornamos una respuesta HTTP 200 OK junto con la lista de usuarios
		return ResponseEntity.ok(users);
	}
	
// Anotacion para mapear solicitudes HTTP GET al metodo, con un paramentro de ruta dinamico
	@GetMapping("/{id}")
	public ResponseEntity<User> obtenerUser(@PathVariable("id") int id){
// Llama al servicio para obtener un usuario por su ID
		User user = userService.getUserById(id);
// Condicion que comprueba si el usuario no existe 
				if (user == null) {
// Si no se encuentra el usuario, retornamos una respuesta HTTP 404 (NOT FOUND)
					return ResponseEntity.notFound().build();
				}
// Si el usuario existe retornamos una respuesta HTTP 200 OK junto con el usuario
		return ResponseEntity.ok(user);
	}
	
	// Metodo para poder guardar el usuario
	// Anotacion que mapea solicitudes HTTP POST al metodo
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
// Llama al servicio para guardar el usuario recibito en la DB
		User newUser = userService.save(user);
// Retornamos una respuesta HTTP 200 OK con el cuarpo recien creado como cuerpo de la respuesta
		return ResponseEntity.ok(newUser);
	}
	
	// Eliminar un usuario por ID
	// Ruta DELETE para eliminar un usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		try {
			// Llamamos al servicio para eliminar el usuario
			User deleteUser = userService.deleteUserById(id);
			// Si se elimino correctamente, retornamos el usaurio eliminado con un codigo 200 OK
			return ResponseEntity.ok(deleteUser);
		} catch(UserNotFoundException e) {
			// Si el usuario no se encuentra, retorna un error 404 con el msj
			return ResponseEntity.status(404).body(null);
		}
	}
	
}
