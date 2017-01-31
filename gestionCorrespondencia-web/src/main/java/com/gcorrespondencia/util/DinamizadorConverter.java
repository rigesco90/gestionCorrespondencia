package com.gcorrespondencia.util;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.gcorrespondencia.entityes.Persona;

/**
 *
 * @author RCAMPO
 */
@FacesConverter("dinamizadorConverter")
public class DinamizadorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		@SuppressWarnings("unchecked")
		List<Persona> lstPersonas = (List<Persona>) context.getApplication().evaluateExpressionGet(context,
				"#{planillaController.getListPersonas()}", List.class);

		if (value.length() > 0) {
			for (Persona persona : lstPersonas) {
				if (persona.getPrimerNombre() != null && persona.getPrimerApellido() != null) {
					if (persona.getPrimerNombre().equals(value) || persona.getPrimerApellido().equals(value)
							|| persona.getNumIdentificacion().equals(value)) {
						return persona;
					}
				} else if (persona.getNumIdentificacion().equals(value) || persona.getRazonSocial().equals(value)) {
					return persona;
				}
			}
		}
		return null;
	}

	/**
	 * Convierte un objeto en un string.
	 *
	 * @param context
	 * @param component
	 * @param value
	 *            Objeto de tipo persona
	 * @return Nombre de la persona
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Persona) value).getNumIdentificacion();
	}

}
