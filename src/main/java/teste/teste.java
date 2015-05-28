package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Disciplina;
import model.Orientacao;

public class teste {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("soa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trs = manager.getTransaction();
		trs.begin();
		
		
		Orientacao orientacao = new Orientacao();
		
		orientacao.setCargaHoraria(68);
		orientacao.setComentarioAluno("Elvis pegou muitas materias. SEFODEU!!!");
		Query consulta = manager.createQuery("select entidade from Disciplina entidade");
		List<Disciplina> lista = consulta.getResultList();
		for(Disciplina di: lista){
			System.out.println(di.getId());
			
			
			
		}
		
		
		trs.commit();
		System.out.println(lista);
		System.exit(0);
	}

}
