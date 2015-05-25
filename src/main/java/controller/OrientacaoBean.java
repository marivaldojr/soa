package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Disciplina;
import model.Orientacao;
import criteria.OrientacaoCriteria;
import dao.DisciplinaDAO;
import dao.OrientacaoDAO;

@ManagedBean(name="orientacaoBean")
@ViewScoped
public class OrientacaoBean implements Serializable{
	
private static final long serialVersionUID = -2486571501053533412L;

	private OrientacaoCriteria criteria;
	
	private Orientacao orientacao;
	
	private List<Disciplina> listaDisciplinas;
	

	private OrientacaoDAO orientacaoDAO;
	
	private DisciplinaDAO disciplinaDAO;
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializei");
		orientacao = new Orientacao();
		orientacaoDAO = new OrientacaoDAO(); 
		disciplinaDAO = new DisciplinaDAO();
		criteria = new OrientacaoCriteria();
	}
	
	public void pesquisar(){
		listaDisciplinas =  disciplinaDAO.buscarPorCriterios(criteria);
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

	public OrientacaoCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(OrientacaoCriteria criteria) {
		this.criteria = criteria;
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
}
