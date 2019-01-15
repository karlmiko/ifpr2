package com.ifpr.comida.dao;

import com.ifpr.comida.Comida;
import com.ifpr.dao.GenericDao;

public class ComidaDaoImpl extends GenericDao<Comida> implements ComidaDao
{
	public ComidaDaoImpl(Class<Comida> classe) 
	{
		super(Comida.class);
	}
}
