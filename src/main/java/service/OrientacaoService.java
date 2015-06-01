package service;

import model.Orientacao;
import model.Usuario;
import dao.OrientacaoDAO;

public class OrientacaoService extends BaseService<Orientacao>{
	
private OrientacaoDAO orientacaoDAO = new OrientacaoDAO();
	
	@Override
	public OrientacaoDAO getDao() {
		return orientacaoDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	Class<Orientacao> tipo() {
		return Orientacao.class;
	}
	
	public Orientacao buscarOrientacaoPorAluno(Usuario aluno){
		return getDao().buscarOrientacaoPorAluno(aluno);
	}

}
