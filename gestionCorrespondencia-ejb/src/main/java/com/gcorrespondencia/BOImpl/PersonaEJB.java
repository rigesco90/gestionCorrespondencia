package com.gcorrespondencia.BOImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gcorrespondencia.bo.PersonaBO;
import com.gcorrespondencia.dao.PersonaDAO;
import com.gcorrespondencia.entityes.CatBarrio;
import com.gcorrespondencia.entityes.CatMunicipio;
import com.gcorrespondencia.entityes.CatTipoPersona;

@Stateless
public class PersonaEJB implements PersonaBO {
	
	@Inject PersonaDAO personaDAO;

	@Override
	public List<CatTipoPersona> listTipoPersona() {
		return personaDAO.listTipoPersona();
	}

	@Override
	public List<CatMunicipio> listMpiosPorDepto(int idDepto) {		
		return personaDAO.listMpiosPorDepto(idDepto);
	}

	@Override
	public List<CatBarrio> listBarriosPorMupio(int idMupio) {
		return personaDAO.listBarriosPorMupio(idMupio);
	}

	@Override
	public List<CatBarrio> listBarriosPorMupioNuevo(int idMpio) {
		return personaDAO.listBarriosPorMupioNuevo(idMpio);
	}

}
