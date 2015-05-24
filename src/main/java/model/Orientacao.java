package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // indica que essa é uma classe JPA
@Table(name="orientacao")
public class Orientacao {

	private Long id;
	private int cargaHoraria;
	private String situacao;
	private String comentarioAluno;
	
	@Id // indica que essa é a primary key
	@GeneratedValue // auto_increment
	@Column(name="id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="comentario_aluno")
	public String getComentarioAluno() {
		return comentarioAluno;
	}
	
	public void setComentarioAluno(String comentario_aluno) {
		this.comentarioAluno = comentario_aluno;
	}
	
	@Column(name="carga_horaria")
	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Column(name="situacao")
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
