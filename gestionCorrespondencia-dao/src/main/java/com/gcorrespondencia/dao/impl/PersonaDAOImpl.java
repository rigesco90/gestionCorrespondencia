package com.gcorrespondencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gcorrespondencia.dao.PersonaDAO;
import com.gcorrespondencia.entityes.CatBarrio;
import com.gcorrespondencia.entityes.CatMunicipio;
import com.gcorrespondencia.entityes.CatTipoPersona;

public class PersonaDAOImpl implements PersonaDAO {

	@PersistenceContext(unitName = "gcorrespondenciaPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CatTipoPersona> listTipoPersona() {
		return em
				.createQuery(
						"SELECT tp FROM CatTipoPersona tp WHERE tp.catTipoPersona.idTipoPersona IS NOT NULL AND tp.catTipoPersona.idTipoPersona != 2")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatMunicipio> listMpiosPorDepto(int idDepto) {
		return em.createQuery("SELECT m FROM CatMunicipio m WHERE m.catDepartamento.idDepartamento = :idDepto")
				.setParameter("idDepto", idDepto).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatBarrio> listBarriosPorMupio(int idMupio) {
		return em.createQuery("SELECT b FROM CatBarrio b WHERE b.catMunicipio.idMunicipio = :idMpio")
				.setParameter("idMpio", idMupio).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatBarrio> listBarriosPorMupioNuevo(int idMpio) {
		return em
				.createQuery(
						"SELECT b FROM CatBarrio b JOIN FETCH b.catMunicipio m JOIN FETCH m.catDepartamento d WHERE b.catMunicipio.idMunicipio = :idMpio")
				.setParameter("idMpio", idMpio).getResultList();
	}

}
