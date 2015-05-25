package criteria;

import java.io.Serializable;

	
public class OrientacaoCriteria implements Serializable {


	private static final long serialVersionUID = -5729710793585815085L;

	private String nome;
	
	private String codigo;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
