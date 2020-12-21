package com.fvarasg.inicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvarasg.inicio.dao.IAgendaDao;
import com.fvarasg.inicio.model.Contacto;

@Service
public class AgendaServiceImpl implements IAgendaService {
	
	@Autowired
	IAgendaDao agendaDao;
	
	@Override
	public void agregarContacto(Contacto contacto) throws Exception{
		if(agendaDao.recuperarContacto(contacto.getIdContacto()) == null) {
			agendaDao.agregarContacto(contacto);
			return;
		}
		throw new Exception("Contacto repetido");
	}

	@Override
	public List<Contacto> recuperarContactos() {
		return agendaDao.devolverContactos();
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		if(agendaDao.recuperarContacto(contacto.getIdContacto()) != null) {
			agendaDao.actualizarContacto(contacto);
		}
	}

	@Override
	public boolean eliminarContacto(int idContacto) {
		if(agendaDao.recuperarContacto(idContacto) != null) {
			agendaDao.eliminarContacto(idContacto);
			return true;
		}
		return false;
	}

	@Override
	public Contacto buscarContacto(int idContacto) {
		return agendaDao.recuperarContacto(idContacto);
	}

}
