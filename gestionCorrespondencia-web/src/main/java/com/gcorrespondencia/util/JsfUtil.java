package com.gcorrespondencia.util;

import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectItem;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

public class JsfUtil {

	public static void addErrorMessage(Exception ex, String defaultMsg) {
		String msg = ex.getLocalizedMessage();
		if (msg != null && msg.length() > 0) {
			addErrorMessage(msg);
		} else {
			addErrorMessage(defaultMsg);
		}
		// FacesContext.getCurrentInstance(). // Invalidate JSF page if we raise
		// an error message
	}

	public static void addErrorMessages(List<String> messages) {
		for (String message : messages) {
			addErrorMessage(message);
		}
		FacesContext.getCurrentInstance().validationFailed();
	}

	public static void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg, "");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		FacesContext.getCurrentInstance().validationFailed(); 
	}

	public static void addErrorMessageWithSummary(String sum, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, sum, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		FacesContext.getCurrentInstance().validationFailed();
	}

	public static void addSuccessMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public static void addWarningMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, "");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public static void addSuccessMessageWithSummary(String sum, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, sum, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public static Throwable getRootCause(Throwable cause) {
		if (cause != null) {
			Throwable source = cause.getCause();
			if (source != null) {
				return getRootCause(source);
			} else {
				return cause;
			}
		}
		return null;
	}

	public static String getExceptionMsg(Exception ex) {
		String msg = "";
		try {
			Throwable cause = JsfUtil.getRootCause(ex.getCause());
			msg = cause.getLocalizedMessage();
		} catch (Exception e) {
			msg = ex.getMessage();
		}
		return msg;
	}

	public static boolean isValidationFailed() {
		return FacesContext.getCurrentInstance().isValidationFailed();
	}

	public static boolean isDummySelectItem(UIComponent component, String value) {
		for (UIComponent children : component.getChildren()) {
			if (children instanceof UISelectItem) {
				UISelectItem item = (UISelectItem) children;
				if (item.getItemValue() == null && item.getItemLabel().equals(value)) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	public static String getComponentMessages(String clientComponent, String defaultMessage) {
		FacesContext fc = FacesContext.getCurrentInstance();
		UIComponent component = UIComponent.getCurrentComponent(fc).findComponent(clientComponent);
		if (component instanceof UIInput) {
			UIInput inputComponent = (UIInput) component;
			if (inputComponent.isValid()) {
				return defaultMessage;
			} else {
				Iterator<FacesMessage> iter = fc.getMessages(inputComponent.getClientId());
				if (iter.hasNext()) {
					return iter.next().getDetail();
				}
			}
		}
		return "";
	}

	public static void showDialogErrorMessage(String message) {
		FacesMessage fmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", message);
		RequestContext.getCurrentInstance().showMessageInDialog(fmessage);
	}

}
