package com.ifpr.pessoa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "tbPessoa")
public abstract class Pessoa 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	protected String nome;

	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public int getId() 
	{
		return id;
	}

	public void mostrarAtributos() 
	{
		
	}
}
