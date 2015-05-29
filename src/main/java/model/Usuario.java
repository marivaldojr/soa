package model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="usuario")
public class Usuario implements Serializable{
		
	
	private static final long serialVersionUID = 3131924706606436212L;

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "matricula", nullable = false)
	private String matricula;
		
	@Column(name = "senha", nullable = false)
	private String senha;
	

	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "tipo", nullable = false)
	private int tipoUsuario;
	
	@OneToMany(fetch=FetchType.LAZY) 
	@JoinTable(name="usuario_orientacao", joinColumns={@JoinColumn(name = "id_orientador", nullable = false, referencedColumnName = "id_orientacao")}, inverseJoinColumns={@JoinColumn(name="id_orientacao", referencedColumnName="id_orientacao")})
    private List<Orientacao> orientacoes;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Orientacao> getOrientacoes() {
		return orientacoes;
	}

	public void setOrientacoes(List<Orientacao> orientacoes) {
		this.orientacoes = orientacoes;
	}


	
	
}
