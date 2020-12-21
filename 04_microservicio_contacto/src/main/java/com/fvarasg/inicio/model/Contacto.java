package com.fvarasg.inicio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "contactos")
@NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
public class Contacto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContacto;

	private int edad;

	private String email;

	private String nombre;

	public Contacto() {
	}

	public Contacto(int idContacto, int edad, String email, String nombre) {
		this.idContacto = idContacto;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
