package bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Usuario;
import dao.UsuarioDAO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -2302379222784229695L;

	private UIComponent loginButton;
	
	private UsuarioDAO usuarioDAO;

	private Usuario usuario;

	private Boolean isAuth = false;
	private String origin = null;

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializei");
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
	}

	public String verificarUsuarioLogado() throws IOException {
		HttpSession session = ((HttpServletRequest)SessionBean.getRequest()).getSession();
		usuario = (Usuario)session.getAttribute("usuario");
		FacesContext context = FacesContext.getCurrentInstance();
		// se nao estiver logado
		if(usuario == null){
			this.origin = ((HttpServletRequest)context.getExternalContext().getRequest()).getRequestURL().toString();
			context.getExternalContext().redirect("login.xhtml");
			return "";
		}else{
			return "index";
		}
	}

	public String logar() {
		System.out.println("logar");
		try {
			usuario = usuarioDAO.autenticar(usuario);
		} catch (Exception e){
			
		}	
		
		if (usuario != null) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("usuario", usuario);
    		System.out.println("logou");
            return "index";
		}else{
			System.out.println("dados incorretos");
			// se nao encontrou usuario ou os dados estao incorretos
			FacesMessage message = new FacesMessage("Dados incorretos");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(loginButton.getClientId(context), message);
            /*FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));*/
            return "login";
		}
	}
	
    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login";
    }
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public void setLoginbutton(UIComponent loginButton) {
        this.loginButton = loginButton;
    }

    public UIComponent getLoginbutton() {
        return loginButton;
    }
    
}
