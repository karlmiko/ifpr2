package com.ifpr.aluno.dao;

import com.ifpr.aluno.Aluno;
import com.ifpr.dao.GenericDao;

public class AlunoDaoImpl extends GenericDao<Aluno> implements AlunoDao{

	public AlunoDaoImpl(Class<Aluno> classe) {
		super(Aluno.class);
		
	}

	
	
}
