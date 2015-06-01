package dao;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.AnoSemestre;
import model.Usuario;

public class AnoSemestreDAO extends BaseDAO<Usuario> {

	@SuppressWarnings("unchecked")
	@Override
	Class<Usuario> tipo() {
		return Usuario.class;
	}

	public AnoSemestre buscarAnoSemestre() {
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		StringBuilder query = new StringBuilder();
		query.append(" select an_se ");
		query.append(" from AnoSemestre an_se ");
	
		query.append(" order by an_se.id desc");

		Query consulta = em.createQuery(query.toString());
		consulta.setMaxResults(1);
		AnoSemestre resultado = (AnoSemestre) consulta.getSingleResult();
		trs.commit();
		em.close();
		return resultado;
	}

}
