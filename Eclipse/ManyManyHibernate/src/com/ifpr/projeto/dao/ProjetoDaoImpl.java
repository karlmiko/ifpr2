package com.ifpr.projeto.dao;

import com.ifpr.dao.GenericDao;
import com.ifpr.projeto.Projeto;

public class ProjetoDaoImpl extends GenericDao<Projeto> implements ProjetoDao
{
	public ProjetoDaoImpl (Class <Projeto> classe)
	{
		super(Projeto.class);
	}
}