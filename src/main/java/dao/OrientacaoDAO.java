package dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.AnoSemestre;
import model.Orientacao;
import model.Usuario;
import criteria.UsuarioCriteria;

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
	
	
	public List<Orientacao> buscarOrientacaoPorCriteria(UsuarioCriteria criteria, AnoSemestre anoSemestre){
		boolean statusCrietria=false;
		
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		StringBuilder query = new StringBuilder();
		query.append(" select orientacao ");
		query.append(" from Orientacao orientacao");
		query.append(" inner join orientacao.aluno aluno");		
		query.append(" inner join orientacao.anoSemestre anoSemestre");		
		query.append(" inner join aluno.orientador orientador");		
		query.append(" where ");
		
		if (!criteria.getMatricula().isEmpty() || !criteria.getNome().isEmpty()) {
			if (!criteria.getMatricula().isEmpty()) {
				statusCrietria = true;
				query.append(" usuario.matricula like '%" + criteria.getMatricula() + "%' ");
		}
			
			if (!criteria.getNome().isEmpty()) {
				if(statusCrietria){
					query.append(" and ");
				}else{
					statusCrietria = true;
				}
				query.append(" usuario.nome = "+ criteria.getNome());
				
			}
			
			
		}
		if(statusCrietria){
			query.append(" and ");
		}
		query.append(" orientador.id = "+criteria.getOrientador());
		query.append(" and anoSemestre.id = "+ anoSemestre.getId());
		query.append(" order by aluno.nome ");	

	
		Query consulta = em.createQuery(query.toString());
		List<Orientacao> orientacoes = consulta.getResultList();
		trs.commit();
		return orientacoes;
	}
	
}
