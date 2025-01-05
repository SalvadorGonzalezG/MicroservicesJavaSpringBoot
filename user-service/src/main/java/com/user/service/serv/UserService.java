package com.user.service.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entities.User;
import com.user.service.models.Car;
import com.user.service.models.Moto;
import com.user.service.repository.UserRepository;

@Service
public class UserService {
	
	// Inyectamos automaticamente una instancia de RestTemplate 
	// RestTemplaate se utiliza para realizar llamadas HTTP A otros microservicios
	@Autowired
	private RestTemplate restTemplate;
	
	// Inyectamos automaticamente una intancia de repository
	// accedemos a las operaciones de la DB sin necesidad de intanciar manualmente el repositorio
	@Autowired
	private UserRepository userRepository;
	
// Método que obtiene una lista de carros asociados a un usuario especifico
// Se realiza una solicitud GET al microservicio usando RestTemplate
	public List<Car> getCars(int userId){
		
// Realizamos una llamada HTTP GET a la URL del microservicio de carros
// conectando el userId al final de la ruta
		List<Car> car = restTemplate.getForObject("http://localhost:8082/car/user" + userId , List.class);
// Retorna la lista de carros obtenida del microservicio		
		return car;
	}
	
	public List<Moto> getMotos(int userId){
		List<Moto> moto = restTemplate.getForObject("http://localhost:8080/moto/user" + userId , List.class);
		return moto;
	}
	
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
