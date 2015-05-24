package dao;

import model.Orientacao;

public class OrientacaoDAO extends BaseDAO<Orientacao>{

	@SuppressWarnings("unchecked")
	@Override
	Class<Orientacao> tipo() {
		return Orientacao.class;
	}

	
}
