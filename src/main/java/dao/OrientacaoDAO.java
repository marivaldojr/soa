package dao;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.AnoSemestre;
import model.Orientacao;
import model.Usuario;

public class OrientacaoDAO extends BaseDAO<Orientacao>{

	@SuppressWarnings("unchecked")
	@Override
	Class<Orientacao> tipo() {
		return Orientacao.class;
	}

	public Orientacao buscarOrientacaoPorAluno(Usuario aluno){
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		StringBuilder query = new StringBuilder();
		query.append(" select orientacao ");
		query.append(" from Orientacao orientacao");
		query.append(" inner join orientacao.aluno aluno");		
		query.append(" where aluno.id =" + aluno.getId());
	
		Query consulta = em.createQuery(query.toString());
		try {
			Orientacao  resultado = (Orientacao) consulta.getSingleResult();
			trs.commit();
			em.close();
			return resultado;
		} catch (Exception e) {
			trs.commit();
			em.close();
			return null;
		}

	}
	
}
