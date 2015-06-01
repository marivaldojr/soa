package service;

import java.util.ArrayList;
import java.util.List;

import criteria.OrientacaoCriteria;
import model.Disciplina;
import dao.DisciplinaDAO;

public class DisciplinaService extends BaseService<Disciplina> {

	private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	
	@Override
	public DisciplinaDAO getDao() {
		return disciplinaDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	Class<Disciplina> tipo() {
		return Disciplina.class;
	}
	
	public ArrayList<Disciplina> buscarPorCriterios(OrientacaoCriteria criteria){
		return getDao().buscarPorCriterios(criteria);
	}
	
	public int calcularCargaHorariaTotal(List<Disciplina> listaDisciplinas ){
		if(listaDisciplinas==null || listaDisciplinas.isEmpty()){
			return 0;
		}else{
			int total=0;
			for(Disciplina disciplina: listaDisciplinas){
				total += disciplina.getCargaHoraria();
			}
			return total;
		}
			
	}

	public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}

}
