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
	}
	
	public void salvar(Modelo entidade) {
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		em.persist(entidade);
		trs.commit();
		em.close();
	}

	public void remover(Modelo entidade) {
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		em.remove(entidade);
		trs.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public Modelo buscarPorId(int id){
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		Modelo resultado = (Modelo) em.find(tipo(), id);
		trs.commit();
		em.close();
		return resultado;
	}

	
	@SuppressWarnings("unchecked")
	public List<Modelo> listarTodos() {
		em = emf.createEntityManager();
		EntityTransaction trs = em.getTransaction();
		trs.begin();
		Query consulta = em.createQuery("select entidade from " + tipo().getSimpleName()  + " entidade");
		List<Modelo> lista = consulta.getResultList();
		trs.commit();
		em.close();
		return lista;
	
	}
	
	@SuppressWarnings("hiding")
	abstract <Modelo> Class<Modelo> tipo();

}
