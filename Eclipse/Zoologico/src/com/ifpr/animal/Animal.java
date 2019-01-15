package com.ifpr.animal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ifpr.animalComida.AnimalComida;
import com.ifpr.brinquedo.Brinquedo;

@Entity
public class Animal 
{
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String especie;
	
	@JoinColumn(name = "id_brinquedo", referencedColumnName = "id")
	@OneToOne (cascade = CascadeType.ALL)
	private Brinquedo brinquedo;
	
	@JoinColumn (name = "id_animal", referencedColumnName = "id")
	@OneToMany (fetch = FetchType.EAGER)
	private List<AnimalComida> comidasFavoritas = new ArrayList <AnimalComida>();
	
	public int getId() {
		return id;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Brinquedo getBrinquedo() {
		return brinquedo;
	}

	public void setBrinquedo(Brinquedo brinquedo) {
		this.brinquedo = brinquedo;
	}
	
	public List<AnimalComida> getComidasFavoritas() {
		return comidasFavoritas;
	}

	public void setComidasFavoritas(List<AnimalComida> comidasFavoritas) {
		this.comidasFavoritas = comidasFavoritas;
	}
}
