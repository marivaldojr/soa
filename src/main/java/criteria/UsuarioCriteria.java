package criteria;

import java.io.Serializable;

	
public class UsuarioCriteria implements Serializable {


	private static final long serialVersionUID = -5729710793585815085L;

	private String nome;
	
	private String matricula;
	
	private Integer orientador;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getOrientador() {
		return orientador;
	}

	public void setOrientador(Integer orientador) {
		this.orientador = orientador;
	}

}
