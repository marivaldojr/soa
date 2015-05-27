package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.mysql.fabric.xmlrpc.base.Array;

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
	
	private Disciplina disciplina;
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	private List<Disciplina> listaDisciplinas;
	
	private List<Disciplina> listaSelecionada;
	
	private List<Disciplina> listaDisciplinasSelecionadas;
	

	
	public List<Disciplina> getListaSelecionada() {
		return listaSelecionada;
	}

	public void setListaSelecionada(List<Disciplina> listaSelecionada) {
		this.listaSelecionada = listaSelecionada;
	}

	private OrientacaoDAO orientacaoDAO;
	
	private DisciplinaDAO disciplinaDAO;
	
	public void adicionarDisciplina(Disciplina disciplina){
		listaDisciplinas.remove(disciplina);
		listaDisciplinasSelecionadas.add(disciplina);
	}
	
	
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializei");
		orientacao = new Orientacao();
		listaSelecionada = new ArrayList<Disciplina>();
		listaDisciplinasSelecionadas = new ArrayList<Disciplina>();
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
	
	public List<Disciplina> getListaDisciplinasSelecionadas() {
		return listaDisciplinasSelecionadas;
	}

	public void setListaDisciplinasSelecionadas(
			List<Disciplina> listaDisciplinasSelecionadas) {
		this.listaDisciplinasSelecionadas = listaDisciplinasSelecionadas;
	}

}
