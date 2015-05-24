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
	EntityTransaction trs;

	protected BaseDAO() {
		emf = Persistence.createEntityManagerFactory("soa");
		em = emf.createEntityManager();
		trs = em.getTransaction();
	}
	
	public void salvar(Modelo entidade) {
		trs.begin();
		em.persist(entidade);
		trs.commit();
		emf.close();
	}

	public void remover(Modelo entidade) {
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public Modelo buscarPorId(int id){
		em.getTransaction().begin();
		Modelo resultado = (Modelo) em.find(tipo(), id);
		em.getTransaction().commit();
		emf.close();
		return resultado;
	}

	
	@SuppressWarnings("unchecked")
	public List<Modelo> listarTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select entidade from " + tipo().getSimpleName()  + " entidade");
		List<Modelo> lista= consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return lista;
	
	}
	
	@SuppressWarnings("hiding")
	abstract <Modelo> Class<Modelo> tipo();

}
