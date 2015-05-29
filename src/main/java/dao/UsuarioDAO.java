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
		em.getTransaction().begin();
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
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		StringBuilder query = new StringBuilder();
		query.append(" select usuario ");
		query.append(" from Usuario usuario ");
		if (criteria.getEmail() != null || criteria.getLogin() != null || criteria.getMatricula() != null || criteria.getNome() != null) {
			query.append(" where ");
		 
			if (criteria.getEmail() != null) {
				statusCrietria = true;
				query.append(" usuario.email like '%" + criteria.getEmail()  + "%' ");	
			}
			
			if (criteria.getLogin() != null) {
				if(statusCrietria){
					query.append(" and ");
				}else{
					statusCrietria = true;
				}
				query.append(" usuario.login like '%" + criteria.getLogin() + "%' ");
			
		}
			
			if (criteria.getMatricula() != null) {
				if(statusCrietria){
					query.append(" and ");
				}else{
					statusCrietria = true;
				}
				query.append(" usuario.matricula like '%" + criteria.getMatricula() + "%' ");
			
		}
			
			if (criteria.getNome() != null) {
				if(statusCrietria){
					query.append(" and ");
				}else{
					statusCrietria = true;
				}
				query.append(" usuario.nome like '%" + criteria.getNome() + "%' ");
			}	
		}
		query.append(" order by usuario.nome ");	

		Query consulta = em.createQuery(query.toString());
		List<Usuario> usuarios = consulta.getResultList();
		trs.commit();
		return usuarios;
	}

}
