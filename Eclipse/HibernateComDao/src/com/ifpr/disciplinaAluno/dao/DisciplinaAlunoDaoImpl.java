package com.ifpr.disciplinaAluno.dao;

import com.ifpr.dao.GenericDao;
import com.ifpr.disciplinaAluno.DisciplinaAluno;

public class DisciplinaAlunoDaoImpl extends GenericDao<DisciplinaAluno> implements DisciplinaAlunoDao
{
	public DisciplinaAlunoDaoImpl(Class<DisciplinaAluno> classe) 
	{
		super(DisciplinaAluno.class);
		
	}
}
