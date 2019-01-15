package com.ifpr.comida;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.ifpr.animalComida.AnimalComida;

@Entity
public class Comida 
{
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn (name = "id_comida", referencedColumnName = "id")
	@OneToMany (fetch = FetchType.EAGER)
	private List <AnimalComida> comidasPreferidas = new ArrayList<AnimalComida>();
	
	
	private String nome;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
