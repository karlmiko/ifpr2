package com.ifpr.dao;

import java.util.List;

public interface Dao<T> {

	public void save(T obj);
	public T update(T obj) ;
	public void remove(T obj);
	public T findById(int id);
	public T findById(long id);
	public List<T> list(int quantidade);
}
