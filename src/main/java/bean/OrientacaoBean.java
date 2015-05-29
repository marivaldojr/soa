package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Disciplina;
import model.Orientacao;
import criteria.OrientacaoCriteria;
import dao.DisciplinaDAO;
import dao.OrientacaoDAO;
import dao.UsuarioDAO;

@ManagedBean(name="orientacaoBean")
@ViewScoped
public class OrientacaoBean implements Serializable{
	
private static final long serialVersionUID = -2486571501053533412L;

	private OrientacaoCriteria criteria;
	
	private Orientacao orientacao;
	
	private Disciplina disciplina;
	
	

	private List<Disciplina> listaDisciplinas;
	
	private List<Disciplina> listaSelecionada;
	
	private List<Disciplina> listaDisciplinasSelecionadas;
	
	private UsuarioDAO usuarioDAO;
	

	
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
	
	public void removerDisciplina(Disciplina disciplina){
		listaDisciplinas.add(disciplina);
		listaDisciplinasSelecionadas.remove(disciplina);
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
		listaDisciplinas.removeAll(listaDisciplinasSelecionadas);
	}
	
	public void salvar() {
		System.out.println("Salvando");
		usuarioDAO = new UsuarioDAO();
		orientacao.setCargaHoraria(300);
		orientacao.setSituacao(1);		
		orientacao.setAnoSemestre("20152");
		orientacao.setComentarioAluno("sdsffsfssfd");
		orientacao.setAluno(usuarioDAO.buscarPorId(1));
		orientacao.setOrientador(usuarioDAO.buscarPorId(5));
		orientacao.setDisciplinas(listaDisciplinasSelecionadas);
		orientacaoDAO.salvar(orientacao);
		
		System.out.println("Salvei");
		
	}
	
	public boolean isRenderedListaDisciplinasSelecionadas(){
		return !(listaDisciplinasSelecionadas==null ||listaDisciplinasSelecionadas.isEmpty());
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
