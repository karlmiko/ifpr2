package com.ifpr.animalComida.dao;

import com.ifpr.animalComida.AnimalComida;
import com.ifpr.dao.GenericDao;

public class AnimalComidaDaoImpl extends GenericDao<AnimalComida> implements AnimalComidaDao 
{
	public AnimalComidaDaoImpl(Class<AnimalComida> classe) 
	{
		super(AnimalComida.class);
	}	
}
