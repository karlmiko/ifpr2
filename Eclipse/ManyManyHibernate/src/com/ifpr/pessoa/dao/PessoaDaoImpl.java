package com.ifpr.pessoa.dao;

import com.ifpr.dao.GenericDao;
import com.ifpr.pessoa.Pessoa;

public class PessoaDaoImpl extends GenericDao<Pessoa> implements PessoaDao 
{
	public PessoaDaoImpl (Class <Pessoa> classe)
	{
		super(Pessoa.class);
	}
}
