package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Orientacao;
import model.Usuario;
import criteria.UsuarioCriteria;
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

	private List<Usuario> listaUsuario;
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializei");
		orientacao = new Orientacao();
		orientacaoDAO = new OrientacaoDAO(); 
		usuarioDAO = new UsuarioDAO();
		criteria = new UsuarioCriteria();
	}
	
	public void pesquisar(){
		listaUsuario =  usuarioDAO.buscarPorCriterios(criteria);
	}
	
	public void salvar() {
		System.out.println("Salvando");
		
		orientacao.setCargaHoraria(100);
		orientacao.setSituacao(1);		
		orientacao.setAluno(usuarioDAO.buscarPorId(1));
//		orientacao.setDisciplinas();
		orientacaoDAO.salvar(orientacao);
		
		System.out.println("Salvei");
		
	}
	
	public boolean isRenderedListaUsuario(){
		return listaUsuario != null;
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

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

}
