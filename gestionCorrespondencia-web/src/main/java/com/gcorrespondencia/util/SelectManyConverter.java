package com.gcorrespondencia.util;

import java.util.List;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;



public class SelectManyConverter implements Converter {
    @SuppressWarnings("unchecked")
	@Override
    public Object getAsObject(FacesContext context, UIComponent component,String value) {
        List<UIComponent> children = component.getChildren();
        UISelectItems items = null;
        for (UIComponent uiComponent: children) {
            if (uiComponent instanceof UISelectItems) {
                items = (UISelectItems) uiComponent;
                break;
            }
        }
        if (items != null) {
            ValueExpression valueExp = items.getValueExpression("value");
            List<Object> valuesList = (List<Object>) valueExp.getValue(FacesContext.getCurrentInstance().getELContext());
            if (null != valuesList) {
                for (Object object: valuesList) {
                    if (object.toString().equals(value)) {
                        return object;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,Object value) {
        return (value == null ? null : value.toString());
    }

}