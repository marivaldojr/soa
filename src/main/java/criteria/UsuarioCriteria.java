package criteria;

import java.io.Serializable;

	
public class UsuarioCriteria implements Serializable {


	private static final long serialVersionUID = -5729710793585815085L;

	private String nome;
	
	private String email;

	private String matricula;
	
	private String login;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


}
