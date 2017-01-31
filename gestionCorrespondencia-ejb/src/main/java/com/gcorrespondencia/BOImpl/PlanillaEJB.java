/**
 * 
 */
package com.gcorrespondencia.BOImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gcorrespondencia.bo.PlanillaBO;
import com.gcorrespondencia.dao.PlanillaDAO;
import com.gcorrespondencia.entityes.CatEstado;
import com.gcorrespondencia.entityes.CatMunicipio;

/**
 * @author RIGO
 *
 */
@Stateless
public class PlanillaEJB implements PlanillaBO {

	@Inject
	PlanillaDAO planillaDao;

	@Override
	public List<CatEstado> estadosPlanilla() {
		return planillaDao.estadosPlanilla();
	}

	@Override
	public List<CatMunicipio> listMpiosPorDepto(int idDepto) {
		return planillaDao.listMpiosPorDepto(idDepto);
	}

}
