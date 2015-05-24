package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import dao.OrientacaoDAO;
import model.Orientacao;

@ManagedBean(name="orientacaoBean")
@ViewScoped
public class OrientacaoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2486571501053533412L;

	private Orientacao orientacao;
	
	@Inject
	private OrientacaoDAO orientacaoDAO;
	
	@PostConstruct 
	public void inicializar(){
		System.out.println("Inicializei");
		orientacao = new Orientacao();
		orientacaoDAO = new OrientacaoDAO(); 
	}
	
	public void salvar() {
		System.out.println("Salvando");
		
		orientacao.setCargaHoraria(100);
		orientacao.setSituacao("ACEITA");		
		orientacaoDAO.salvar(orientacao);
		
		System.out.println("Salvei");
		
		resetForm();
	}

	private void resetForm() {
		orientacao.setComentarioAluno(null);
	}

	public Orientacao getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}
}
