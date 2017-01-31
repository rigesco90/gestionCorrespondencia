package com.gcorrespondencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gcorrespondencia.dao.PlanillaDAO;
import com.gcorrespondencia.entityes.CatEstado;
import com.gcorrespondencia.entityes.CatMunicipio;

public class PlanillaDAOImpl implements PlanillaDAO {
	@PersistenceContext(unitName = "gcorrespondenciaPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CatEstado> estadosPlanilla() {
		return em.createQuery("SELECT ep FROM CatEstado ep where ep.catCabEstado.idcatCabEstado = 1").
				getResultList();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatMunicipio> listMpiosPorDepto(int idDepto) {
		return em.createQuery("SELECT m FROM CatMunicipio m WHERE m.catDepartamento.idDepartamento = :idDepto")
				.setParameter("idDepto", idDepto).getResultList();
	}

}
