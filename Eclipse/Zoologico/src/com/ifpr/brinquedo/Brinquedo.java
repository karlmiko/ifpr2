package com.ifpr.brinquedo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "tbBrinquedo")
public class Brinquedo 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;

	public int getId() 
	{
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
