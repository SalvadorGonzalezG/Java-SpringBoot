package com.pandevs.pandevs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// Para indicar que esta clase es un controlador de excepciones agrego la anotacion @ControllerAdvice
@ControllerAdvice
public class EmailNotFoundController {
	// La clase percibe anotaciones que nos permiten controlar el metodo de la excepcion y aplicarlo en metodos de tipo ResponseEntity
	// Metodo para manejar la exception y que retorna un mensaje
	@ResponseBody
	@ExceptionHandler(EmailNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String userNotFoundHandler(EmailNotFoundException e) {
		return e.getMessage();
	}
}
