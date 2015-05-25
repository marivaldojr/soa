package dao;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import model.Disciplina;
import criteria.OrientacaoCriteria;

public class DisciplinaDAO extends BaseDAO<Disciplina> implements Serializable{

	
	private static final long serialVersionUID = 625132341260575742L;

	@SuppressWarnings("unchecked")
	@Override
	Class<Disciplina> tipo() {
		return Disciplina.class;
	}

	public List<Disciplina> buscarPorCriterios(OrientacaoCriteria criteria) {
		trs.begin();
		StringBuilder query = new StringBuilder();
		query.append(" select disciplina ");
		query.append(" from Disciplina disciplina ");
		if(criteria==null){
			return null;
		}
		if (!criteria.getCodigo().isEmpty() && !criteria.getCodigo().isEmpty()) {
			query.append(" where ");
			query.append(" disciplina.codigo like '%" + criteria.getCodigo() + "%' ");
			query.append(" and disciplina.nome like '%" + criteria.getNome() + "%' ");

		} else {
			if (!criteria.getCodigo().isEmpty()) {
				query.append(" where disciplina.codigo like '%" + criteria.getCodigo() + "%' ");
			}
			if (!criteria.getNome().isEmpty()) {
				query.append(" where disciplina.nome like '%" + criteria.getNome() + "%' ");
			}
		}
		query.append(" order by disciplina.nome ");	

		Query consulta = em.createQuery(query.toString());
		List<Disciplina> disciplinas = consulta.getResultList();
		trs.commit();
		emf.close();
		return disciplinas;
	}

}
