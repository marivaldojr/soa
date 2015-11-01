package dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import criteria.UsuarioCriteria;
import model.Disciplina;
import model.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario> {

	@SuppressWarnings("unchecked")
	@Override
	Class<Usuario> tipo() {
		return Usuario.class;
	}

	public Usuario autenticar(Usuario usuario) {
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		Query consulta = em
				.createQuery("select usuario from Usuario usuario where usuario.senha ='"
						+ usuario.getSenha()
						+ "' and usuario.login ='"
						+ usuario.getLogin() + "'");
		try{
			consulta.getSingleResult();
			Usuario usuarioResult = (Usuario) consulta.getSingleResult();
			em.getTransaction().commit();
			emf.close();
			return usuarioResult;
		}catch (Exception e) {
			emf.close();
			return null;
		}
	}
	
	public List<Usuario> buscarPorCriterios(UsuarioCriteria criteria) {
		boolean statusCrietria=false;
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		StringBuilder query = new StringBuilder();
		query.append(" select usuario ");
		query.append(" from Usuario usuario ");
		query.append(" inner join usuario.orientador orientador");		
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
		query.append(" order by usuario.nome ");	

		Query consulta = em.createQuery(query.toString());
		List<Usuario> usuarios = consulta.getResultList();
		trs.commit();
		return usuarios;
	}

}
