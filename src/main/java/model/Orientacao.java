package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

import enums.SituacaoEnum;

@Entity
@Table(name ="orientacao")
public class Orientacao{
	
	@Id
	@Column(name="id_orientacao")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@ManyToOne(fetch=FetchType.LAZY) 	
	@JoinColumn(name = "id_aluno", nullable = false,  referencedColumnName = "id_usuario")  
	@ForeignKey(name="fk_aluno_id")
	private Usuario aluno;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY) 	
	@JoinColumn(name = "id_orientador", nullable = false, referencedColumnName = "id_usuario")  
	@ForeignKey(name="fk_orientador_id")
	private Usuario orientador;

	
	@Column(name = "comentario_aluno", nullable = false, length=255)
	private String comentarioAluno;
	
	@Column(name = "comentario_orientador", nullable = true, length=255)
	private String comentarioOrientador;

	
	@Column(name = "ano_semestre", nullable = false, length=5)
	private String anoSemestre;

	@Column(name = "carga_horaria", nullable = false)
	private int cargaHoraria;
	
	@Column(name = "situacao", nullable = false)
	private Integer situacao;
	
	@Transient
	private SituacaoEnum situacaoTipo;

	
	@ManyToMany    
	@JoinTable(name = "orientacao_disciplina", joinColumns = { 
			@JoinColumn(name = "id_orientacao", nullable = false)
			}, 
			inverseJoinColumns = { @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina",
					nullable = false) })
	private List<Disciplina> disciplinas;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Usuario getOrientador() {
		return orientador;
	}

	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
	}

	public String getComentarioAluno() {
		return comentarioAluno;
	}

	public void setComentarioAluno(String comentarioAluno) {
		this.comentarioAluno = comentarioAluno;
	}

	public String getComentarioOrientador() {
		return comentarioOrientador;
	}

	public void setComentarioOrientador(String comentarioOrientador) {
		this.comentarioOrientador = comentarioOrientador;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public SituacaoEnum getSituacaoTipo() {
		return situacaoTipo;
	}

	public void setSituacaoTipo(SituacaoEnum situacaoTipo) {
		this.situacaoTipo = situacaoTipo;
	}

	public String getAnoSemestre() {
		return anoSemestre;
	}

	public void setAnoSemestre(String anoSemestre) {
		this.anoSemestre = anoSemestre;
	}
	
	
}
