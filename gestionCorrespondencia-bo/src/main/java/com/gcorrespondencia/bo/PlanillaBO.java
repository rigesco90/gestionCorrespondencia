package com.gcorrespondencia.bo;

import java.util.List;
import javax.ejb.Local;
import com.gcorrespondencia.entityes.CatEstado;
import com.gcorrespondencia.entityes.CatMunicipio;

@Local
public interface PlanillaBO {
	
	public List<CatEstado> estadosPlanilla();
	
	public List<CatMunicipio> listMpiosPorDepto(int idDepto);

}
