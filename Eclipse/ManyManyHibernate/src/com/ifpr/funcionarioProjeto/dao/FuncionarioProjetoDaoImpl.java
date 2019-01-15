package com.ifpr.funcionarioProjeto.dao;

import com.ifpr.dao.GenericDao;
import com.ifpr.funcionarioProjeto.FuncionarioProjeto;

public class FuncionarioProjetoDaoImpl extends GenericDao<FuncionarioProjeto> implements 
														FuncionarioProjetoDao 
{
	public FuncionarioProjetoDaoImpl (Class <FuncionarioProjeto> classe)
	{
		super(FuncionarioProjeto.class);
	}
}
