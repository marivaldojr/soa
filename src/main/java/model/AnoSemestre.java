package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ano_semestre")
public class AnoSemestre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6778158993912326418L;

	
	@Id
	@Column(name = "id_ano_semestre")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ano",  nullable = false)
	private int ano;
	
	@Column(name = "semestre", nullable = false)
	private int semestre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	

}
