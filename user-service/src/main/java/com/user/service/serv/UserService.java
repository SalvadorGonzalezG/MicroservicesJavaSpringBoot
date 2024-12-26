package com.user.service.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.User;
import com.user.service.repository.UserRepository;

@Service
public class UserService {
	
	// Inyectamos automaticamente una intancia de repository
	// accedemos a las operaciones de la DB sin necesidad de intanciar manualmente el repositorio
	@Autowired
	private UserRepository userRepository;
	
	// Metodo para obtener todos los usuarios de la DB
	// Utilizamos el metodo findAll del repository que devuelve una lista con todos los usuario
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	// Metodo para obtener un usuario por su ID
	// Utiliza el metodo findById() del repositorio que devuelve un OPTIONAL
	// Si no encuentra al usuario devuelve Null
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	// Metodo para guarda un nuevo usuario en la DB
	// Utiliza el metodo save() del repositorio, que guarda la entidad y devuelve el objeto creado
	public User save(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}
	
	// etodo para borrar un usuario de la DB
	// Utilizamos el metodo 
	public User deleteUserById(int id) {
	    Optional<User> user = userRepository.findById(id);
	    if (user.isPresent()) {
	        userRepository.deleteById(id);
	        return user.get(); // Retorna el usuario eliminado
	    }
	    return user.get();
	}
}
