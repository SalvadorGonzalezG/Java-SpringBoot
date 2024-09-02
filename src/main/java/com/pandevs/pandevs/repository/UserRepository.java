package com.pandevs.pandevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pandevs.pandevs.model.User;

	// Es una interface porque aqui viviran todos los metodos  y podran tener varias formas
	//Interfaz que hereda los metodos de Jpa repository y toma los parametros, el objeto model y el tipo de dato de la pk 
public interface UserRepository extends JpaRepository<User, Long>{
	//Mas adelante aqui podremos realizar consultas (QUery): JQPL (Investigar)
	
	// para poder crear un metodo
	@Query("SELECT u FROM User u WHERE u.email = ?1 ")
	User findByEmail(String email);
	
}
