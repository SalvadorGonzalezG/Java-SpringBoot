package com.pandevs.pandevs.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// para convertir mi Java Class (POJO) en una entidad. Necesito las anotaciones de JPA (jAVA PERSISTANCE API). Ademas JPA me exige necesita un constructor vacio
/* Anotaciones de JPA
 * - @Entity para indicar que dicha clase es una entidad OMR
 * - @Table(name = "tableName", schema = "db") para indicar el nombre que llevara mi tabla en el schema especificado
 * - @Id para indicar una llave primaria (PK)
 * - @GeneratedValue nos permite crear una estrategia para la generacion de la PK
 * - @Column me permite configurar cada variable o atributo como una columna de una tabla
 * 
 * */
@Entity
@Table(name = "user")
public class User {
	// Crear un objeto con id, username, email y password
	@Id // llave primaria de una entidad
	@GeneratedValue(strategy = GenerationType.IDENTITY) // todo lo que se genera es autoincrementable
	@Column(name = "id_user")
	private Long id;
	@Column(name = "username", length = 60, nullable=false, unique= true)
	private String username;
	@Column(name = "email", length = 120, nullable=false, unique= true)
	private String email;
	@Column(name = "password", length = 60, nullable=false, unique= false)
	private String password;
	
	// constructor vacio para JPA
	public User() {
		
	}
	
	// Metodo constructor
	public User(Long id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	// getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// Metodo toString
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	//hashCode
	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, username);
	}
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
}
