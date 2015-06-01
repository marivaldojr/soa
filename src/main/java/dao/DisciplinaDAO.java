package dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
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

	public ArrayList<Disciplina> buscarPorCriterios(OrientacaoCriteria criteria) {
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
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
		ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) consulta.getResultList();
		trs.commit();
		em.close();
		return disciplinas;
	}

}
