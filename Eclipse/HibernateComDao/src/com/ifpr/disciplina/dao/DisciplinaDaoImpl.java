package com.ifpr.disciplina.dao;

import com.ifpr.dao.GenericDao;
import com.ifpr.disciplina.Disciplina;

public class DisciplinaDaoImpl extends GenericDao<Disciplina> implements DisciplinaDao
{
	public DisciplinaDaoImpl(Class<Disciplina> classe) {
		super(Disciplina.class);
		
	}
}
