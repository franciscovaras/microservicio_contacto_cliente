package com.fvarasg.inicio.service;

import java.util.List;

import com.fvarasg.inicio.model.Contacto;

public interface IAgendaService {
	
	public void agregarContacto(Contacto contacto) throws Exception;
	List<Contacto> recuperarContactos();
	public void actualizarContacto(Contacto contacto);
	boolean eliminarContacto(int idContacto);
	Contacto buscarContacto(int idContacto);
}
