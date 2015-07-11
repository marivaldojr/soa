package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Disciplina;
import model.Orientacao;
import service.DisciplinaService;
import service.OrientacaoService;
import service.UsuarioService;
import criteria.OrientacaoCriteria;

@ManagedBean(name="orientacaoBean")
@ViewScoped
public class OrientacaoBean extends BaseBean{
	
private static final long serialVersionUID = -2486571501053533412L;

	private OrientacaoCriteria criteria;
			
	private List<Disciplina> listaDisciplinas;
	
	private List<Disciplina> listaDisciplinasSelecionadas;

	private DisciplinaService disciplinaService;

	private UsuarioService usuarioService;
	
	private OrientacaoService orientacaoService;
	
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
		listaDisciplinasSelecionadas = new ArrayList<Disciplina>();
		disciplinaService= new DisciplinaService();
		usuarioService = new UsuarioService();
		orientacaoService = new OrientacaoService();
		criteria = new OrientacaoCriteria();
	}
	
	public void pesquisar(){
		listaDisciplinas =  disciplinaService.buscarPorCriterios(criteria);
		listaDisciplinas.removeAll(listaDisciplinasSelecionadas);
	}
	
	public String avancar() {
		if(listaDisciplinasSelecionadas.isEmpty() || listaDisciplinasSelecionadas == null){
			addMensagemAviso("Selecione ao menos uma disciplina");
			return null;
		}else{ 
			return "confirmarOrientacao";
		}
	}
	
	public boolean isRenderedListaDisciplinasSelecionadas(){
		return !(listaDisciplinasSelecionadas==null ||listaDisciplinasSelecionadas.isEmpty());
	}
	

	public boolean isRenderedOrientacao(){
		return orientacaoService.buscarOrientacaoPorAluno(usuarioService.buscarPorId(2))==null;
	}

	// Getters e Setters ---------------------------------------
	
	
	
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
