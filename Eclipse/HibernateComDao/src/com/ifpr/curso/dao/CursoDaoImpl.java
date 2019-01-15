package com.ifpr.curso.dao;

import com.ifpr.curso.Curso;
import com.ifpr.dao.GenericDao;

public class CursoDaoImpl extends GenericDao<Curso> implements CursoDao
{
	public CursoDaoImpl(Class<Curso> classe) {
		super(Curso.class);
	}
}
