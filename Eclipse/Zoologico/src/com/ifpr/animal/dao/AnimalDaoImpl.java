package com.ifpr.animal.dao;

import com.ifpr.animal.Animal;
import com.ifpr.dao.GenericDao;

public class AnimalDaoImpl extends GenericDao<Animal> implements AnimalDao
{
	public AnimalDaoImpl(Class<Animal> classe) 
	{
		super(Animal.class);
	}
}
