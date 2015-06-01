package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8390598206828546368L;

	  public static Object getSessionMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	    }
	 
	 public static void setSessionMapValue(String key, Object value) {
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
	    }
	  
	protected void addMensagemAviso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem));
            }

    protected void addMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
   }

    protected void addMensagemInformacao(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
    }
}
