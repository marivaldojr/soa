package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Orientacao;

public class teste {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("soa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trs = manager.getTransaction();
		trs.begin();
		
		
		Orientacao orientacao = new Orientacao();
		
		orientacao.setCargaHoraria(68);
		orientacao.setSituacao("ACEITA");
		orientacao.setComentarioAluno("Elvis pegou muitas materias. SEFODEU!!!");
		
		manager.persist(orientacao);
		trs.commit();
		
		System.exit(0);
	}

}
