package com.fvarasg.inicio.dao;

import java.util.List;

import com.fvarasg.inicio.model.Contacto;

public interface IAgendaDao {

	void agregarContacto(Contacto contacto);

	Contacto recuperarContacto(String email);

	void eliminarContacto(String email);

	List<Contacto> devolverContactos();

	void eliminarContacto(int idContacto);

	Contacto recuperarContacto(int idContacto);

	void actualizarContacto(Contacto contacto);

}
