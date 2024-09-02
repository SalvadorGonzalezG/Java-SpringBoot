package com.pandevs.pandevs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pandevs.pandevs.exceptions.EmailNotFoundException;
import com.pandevs.pandevs.model.User;
import com.pandevs.pandevs.service.UserService;

@RestController // indica que es un controller
@RequestMapping("/api/v1")
public class UserController {
	// Mandamos a llamar a Service
	private UserService userService;
	
	//inyeccion de dependencias en el constructor
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//Mapear métodos (get,post, put, delete)
	@GetMapping("/pandelovers")
	public List<User> getMappingAll(){
		return userService.getAll(); // retornando el metodo que viene de service.
	}
	
	// Maperar metodo Post que reciba un nuevo objeto y el body del mismo (@RequestBody), en postaman tengo que construr el body de la entidad 
	@PostMapping
	public User newUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	// Mapear metodo Delete que apunta a un Id especifico. Para ello debemos permitir que el Id sea variable en el endpoint (PathVariable)
	@DeleteMapping("/pandelovers/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userService.deleteUser(id);
	}
	
	// Mapear metodo get by Id que apunte a un metodo especifico
	@GetMapping("/pandelovers/{id}")
	public User getById(@PathVariable(name = "id") Long id) {
		return userService.getById(id);
	}
	
	// Mapear metodo getByEmail utilizando aplicando la query (JPQL) y la excepcion 
	// -- @ResponseEntity<Entity> clase de Spring que me permite reperesenytar repuestas HTTP personalizables
	// -- @RequestParam(parametro) 
	// -- Creamos clase EmailNotFoundException y su clase controller EmailNotFoundController
	@GetMapping("/pandelovers/email")
	public ResponseEntity<User> getByEmail(@RequestParam(name = "pandemail") String email) {
		User userByEmail = userService.getByEmail(email);
		if (userByEmail == null) {
			throw new EmailNotFoundException(email);// Excepcion
		}
		return new ResponseEntity<User>(userByEmail, HttpStatus.OK);
	}
}
