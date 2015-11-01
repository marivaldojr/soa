package bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Orientacao;
import model.Usuario;
import service.OrientacaoService;
import dao.UsuarioDAO;
import enums.SituacaoEnum;

@ManagedBean(name = "visualizarOrientacaoBean")
@ViewScoped
public class VisualizarOrientacaoBean extends BaseBean {

	private static final long serialVersionUID = -2486531501053533412L;

	private Orientacao orientacao;

	private UsuarioDAO usuarioDAO;

	private OrientacaoService orientacaoService;

	private Usuario usuario;

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializei");
		usuarioDAO = new UsuarioDAO();
		orientacaoService = new OrientacaoService();
		usuario = usuarioDAO.buscarPorId(2);
	
		if (orientacao == null ||orientacao.getAluno() == null) {
			orientacao = orientacaoService.buscarOrientacaoPorAluno(usuarioDAO
					.buscarPorId(1));

		}
	
	}
	
	public String aceitar(){
		orientacao.setSituacao(SituacaoEnum.ACEITA.getCodigo());
		orientacaoService.salvar(orientacao);
		return "buscarAlunos";
	}
	
	public String rejeitar(){
		orientacao.setSituacao(SituacaoEnum.RECUSADA.getCodigo());
		orientacaoService.salvar(orientacao);
		return "buscarAlunos";
	}

	public boolean isRenderedOrientacao() {
		return orientacaoService.buscarOrientacaoPorAluno(usuarioDAO
				.buscarPorId(1)) != null;
	}

	public boolean isOrientador() {
		return usuario.getId() == 2;
	}

	public Orientacao getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}

}
