package com.fvarasg.inicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fvarasg.inicio.model.Contacto;

public interface IAgendaJpaSpringDao extends JpaRepository<Contacto, Integer>{
	Contacto findByEmail(String email);
	@Transactional
	@Modifying
	@Query("Delete from Contacto c Where c.email=?1")
	public void eliminarPorEmail(String email);

}
