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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

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
	
	@ManyToOne(fetch=FetchType.LAZY) 	
	@JoinColumn(name = "id_orientador", nullable = true, referencedColumnName = "id_usuario")  
	@ForeignKey(name="fk_orientador_id")
	private Usuario orientador;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "matricula", nullable = true)
	private String matricula;
		
	@Column(name = "senha", nullable = false)
	private String senha;
	

	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "tipo", nullable = false)
	private int tipoUsuario;	

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

	public Usuario getOrientador() {
		return orientador;
	}

	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
	}

	
	
}
