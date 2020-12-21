package com.fvarasg.inicio.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fvarasg.inicio.model.Contacto;

@Repository
public class AgendaDaoImpl implements IAgendaDao {
	
	@Autowired
	IAgendaJpaSpringDao agendaJpaDao;
	
	@Override
	public void agregarContacto(Contacto contacto) {
		agendaJpaDao.save(contacto);

	}

	@Override
	public Contacto recuperarContacto(String email) {
		return agendaJpaDao.findByEmail(email);
	}

	@Override
	public void eliminarContacto(String email) {
		agendaJpaDao.eliminarPorEmail(email);

	}

	@Override
	public List<Contacto> devolverContactos() {
		return agendaJpaDao.findAll();
	}

	@Override
	public void eliminarContacto(int idContacto) {
		agendaJpaDao.deleteById(idContacto);

	}

	@Override
	public Contacto recuperarContacto(int idContacto) {
		return agendaJpaDao.findById(idContacto).orElse(null);
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agendaJpaDao.save(contacto);

	}

}
