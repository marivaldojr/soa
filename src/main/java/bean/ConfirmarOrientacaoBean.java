package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.AnoSemestre;
import model.Disciplina;
import model.Orientacao;
import service.DisciplinaService;
import service.OrientacaoService;
import criteria.OrientacaoCriteria;
import dao.AnoSemestreDAO;
import dao.DisciplinaDAO;
import dao.OrientacaoDAO;
import dao.UsuarioDAO;

@ManagedBean(name = "confirmarOrientacaoBean")
@ViewScoped
public class ConfirmarOrientacaoBean extends BaseBean {

	private static final long serialVersionUID = -2486571501053533412L;

	private OrientacaoCriteria criteria;

	private Orientacao orientacao;

	private Disciplina disciplina;

	private DisciplinaService disciplinaService;

	private AnoSemestreDAO anoSemestreDao;
	
	private List<Disciplina> listaDisciplinas;

	private UsuarioDAO usuarioDAO;

	private OrientacaoService orientacaoService;

	private DisciplinaDAO disciplinaDAO;

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializei");

		orientacao = new Orientacao();
		orientacaoService = new OrientacaoService();
		disciplinaService = new DisciplinaService();
		criteria = new OrientacaoCriteria();
		usuarioDAO = new UsuarioDAO();
		anoSemestreDao = new AnoSemestreDAO();
		orientacao.setCargaHoraria(disciplinaService.calcularCargaHorariaTotal(listaDisciplinas));
		

	}

	public void pesquisar() {
		listaDisciplinas = disciplinaDAO.buscarPorCriterios(criteria);
	}

	public String salvar() {
		if(!isRenderedOrientacao()){
			addMensagemAviso("Você ja cadastrou uma orientação");
			return null;
		}

		if (orientacao.getComentarioAluno() == null
				|| orientacao.getComentarioAluno().isEmpty()) {
			addMensagemAviso("Preencha os campos obrigatórios");
			return null;
		} else {
			System.out.println("Salvando");
			orientacao.setSituacao(1);
			orientacao.setAluno(usuarioDAO.buscarPorId(2));
			orientacao.setOrientador(orientacao.getAluno().getOrientador());
			orientacao.setAnoSemestre(anoSemestreDao.buscarAnoSemestre());
			orientacao.setDisciplinas(listaDisciplinas);
			orientacaoService.salvar(orientacao);
			System.out.println("Salvei");
			return "orientacaoConfirmada";
		}
	}
	
	
	public boolean isRenderedOrientacao() {
		return orientacaoService.buscarOrientacaoPorAluno(usuarioDAO.buscarPorId(2))==null;
	}
	

	public boolean isExisteDisciplinaSelecionada() {
		return listaDisciplinas!=null && !listaDisciplinas.isEmpty();
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
