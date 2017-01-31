package com.gcorrespondencia.bo;

import java.util.List;

import javax.ejb.Local;

import com.gcorrespondencia.entityes.CatBarrio;
import com.gcorrespondencia.entityes.CatMunicipio;
import com.gcorrespondencia.entityes.CatTipoPersona;

@Local
public interface PersonaBO {
	
	public List<CatTipoPersona> listTipoPersona();
	
	public List<CatMunicipio> listMpiosPorDepto(int idDepto);
	
	public List<CatBarrio> listBarriosPorMupio(int idMpio);
	
	public List<CatBarrio> listBarriosPorMupioNuevo(int idMpio);

}
