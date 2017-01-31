package com.gcorrespondencia.dao;

import java.util.List;

import com.gcorrespondencia.entityes.CatBarrio;
import com.gcorrespondencia.entityes.CatMunicipio;
import com.gcorrespondencia.entityes.CatTipoPersona;

public interface PersonaDAO {
	
	public List<CatTipoPersona> listTipoPersona();
	
	public List<CatMunicipio> listMpiosPorDepto(int idDepto);
	
	public List<CatBarrio> listBarriosPorMupio(int idMpio);
	
	public List<CatBarrio> listBarriosPorMupioNuevo(int idMpio);

}
