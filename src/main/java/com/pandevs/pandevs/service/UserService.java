package com.pandevs.pandevs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandevs.pandevs.exceptions.UserNotFoundException;
import com.pandevs.pandevs.model.User;
import com.pandevs.pandevs.repository.UserRepository;

@Service
public class UserService {
	// Mando a llamar userRepository
	private UserRepository userRepository;

	
	//inyeccion de dependencias en el constructor
	@Autowired // permite la inyeccion de dependencias.
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	// metodo para obtener todos los usuarios
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	//Método para crear un nuevo usuario.
	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}
	
	// Método para eliminar un usuario mediante id
	public void deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			// Eliminar
			userRepository.deleteById(id);
		}else {
			// Lanza una Exception.
			throw new UserNotFoundException(id);
		}
	}
	
	// Método para recuperar usuarios por Id (validar si existe)
		public User getById(Long id) {
			return userRepository.findById(id)
					.orElseThrow(() -> new UserNotFoundException(id));
		}
		
		// Método para recuperar usuario por Id (sin excepción, de tipo Optional)
		/*
		public Optional<User> getById(Long id) {
			return userRepository.findById(id);
		}
		*/
	
	// Método para recuperar usuarios por email (con excepciones y de tipo User)
		public User getByEmail(String email) {
			return userRepository.findByEmail(email);
					
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
