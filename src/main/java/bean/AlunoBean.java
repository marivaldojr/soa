package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Disciplina;
import model.Orientacao;
import model.Usuario;
import criteria.UsuarioCriteria;
import dao.AnoSemestreDAO;
import dao.OrientacaoDAO;
import dao.UsuarioDAO;

@ManagedBean(name="alunoBean")
@ViewScoped
public class AlunoBean implements Serializable{
	
private static final long serialVersionUID = -2486571501053533412L;

	private UsuarioCriteria criteria;
	
	private Orientacao orientacao;

	private OrientacaoDAO orientacaoDAO;
	
	private UsuarioDAO usuarioDAO;

	private AnoSemestreDAO anoSemestreDao;

	private List<Orientacao> listaOrientacoes;
	
	private Usuario usuario;
	
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializei");
		orientacao = new Orientacao();
		orientacaoDAO = new OrientacaoDAO(); 
		usuarioDAO = new UsuarioDAO();
		criteria = new UsuarioCriteria();
		usuario = usuarioDAO.buscarPorId(5);
		anoSemestreDao = new AnoSemestreDAO();
		
		criteria.setOrientador(usuario.getId());
	}
	
	public void pesquisar(){
		listaOrientacoes =  orientacaoDAO.buscarOrientacaoPorCriteria(criteria, anoSemestreDao.buscarAnoSemestre());
	}
	
	public String visualizarOrientacao(Orientacao orientacao){
		this.orientacao = orientacao;
		return "visualizarOrientacao";
	}

	
	public boolean isRenderedListaUsuario(){
		return listaOrientacoes != null;
	}
	
	public Orientacao getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}

	public UsuarioCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(UsuarioCriteria criteria) {
		this.criteria = criteria;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Orientacao> getListaOrientacoes() {
		return listaOrientacoes;
	}

	public void setListaOrientacoes(List<Orientacao> listaOrientacoes) {
		this.listaOrientacoes = listaOrientacoes;
	}

}
