package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public abstract class BaseDAO<Modelo> {
	
	EntityManagerFactory emf;
	EntityManager em;
	


	public BaseDAO() {
		emf = Persistence.createEntityManagerFactory("soa");
		em = emf.createEntityManager();
	
	}
	
	public void salvar(Modelo entidade) {

		EntityTransaction trs = em.getTransaction();
		trs.begin();
		em.persist(entidade);
		trs.commit();
	}

	public void remover(Modelo entidade) {
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		em.remove(entidade);
		trs.commit();
	}
	
	@SuppressWarnings("unchecked")
	public Modelo buscarPorId(int id){
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		Modelo resultado = (Modelo) em.find(tipo(), id);
		trs.commit();
		return resultado;
	}

	
	@SuppressWarnings("unchecked")
	public List<Modelo> listarTodos() {
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		Query consulta = em.createQuery("select entidade from " + tipo().getSimpleName()  + " entidade");
		List<Modelo> lista = consulta.getResultList();
		trs.commit();
		return lista;
	
	}
	
	@SuppressWarnings("hiding")
	abstract <Modelo> Class<Modelo> tipo();

}
