package com.ifpr.telefone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbTelefone")
public class Telefone 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone")
	private int id;
	private int telefone;
	private int ddd;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getTelefone()
	{
		return telefone;
	}
	
	public void setTelefone(int telefone)
	{
		this.telefone = telefone;
	}
	
	public int getDdd() 
	{
		return ddd;
	}
	
	public void setDdd(int ddd)
	{
		this.ddd = ddd;
	}
}
