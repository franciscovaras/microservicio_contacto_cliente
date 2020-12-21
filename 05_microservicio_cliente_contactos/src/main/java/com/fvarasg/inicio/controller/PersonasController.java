package com.fvarasg.inicio.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fvarasg.inicio.model.Persona;

@RestController
public class PersonasController {

	String url ="http://servicio-contactos";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> altaPersonas(@PathVariable String nombre, @PathVariable String email,
			@PathVariable int edad) {

		Persona persona = new Persona(nombre, email, edad);
		try {
			//al lanzar la petición post, si la respuesta contiene un código de error
			//diferente a 200, se producirá una excepción
			restTemplate.postForLocation(url + "/contactos", persona);
			//si todo ha ido bien, devolvemos como respuesta la lista de persona
			//e indicamos OK como código de estado de respuesta
			Persona[] personas = restTemplate.getForObject(url + "/contactos", Persona[].class);
			return new ResponseEntity<List<Persona>>(Arrays.asList(personas), HttpStatus.OK);
		} catch (HttpStatusCodeException exception) {
			// si hubo error en la llamada al microservicio, enviamos a nuestro cliente
			// final
			// una cabecera con el mensaje de error, una lista vacía de personas en el
			// cuerpo
			// y el código de estado enviado desde el microservicio
			HttpHeaders headers = new HttpHeaders();
			headers.add("error", exception.getResponseBodyAsString());
			return new ResponseEntity<List<Persona>>(new ArrayList<Persona>(), headers, exception.getStatusCode());
		}

	}

	@GetMapping(value = "personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> buscarEdades(@PathVariable int edad1, @PathVariable int edad2) {
		Persona[] personas = restTemplate.getForObject(url + "/contactos", Persona[].class);
		return Arrays.stream(personas).filter(p -> p.getEdad() >= edad1 && p.getEdad() <= edad2)
				.collect(Collectors.toList());

	}
}
