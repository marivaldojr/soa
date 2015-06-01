package service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.BaseDAO;

@SuppressWarnings({"rawtypes", "unchecked", "hiding"})
public abstract class BaseService<Modelo> {
	
	public abstract BaseDAO getDao();

	public void salvar(Modelo entidade) {
		getDao().salvar(entidade);
	}

	public void remover(Modelo entidade) {
		getDao().remover(entidade);
	}
	
	public Modelo buscarPorId(int id){
		return (Modelo) getDao().buscarPorId(id);
	}

	
	public List<Modelo> listarTodos() {
		return getDao().listarTodos();
	
	}
	
	abstract <Modelo> Class<Modelo> tipo();

}
