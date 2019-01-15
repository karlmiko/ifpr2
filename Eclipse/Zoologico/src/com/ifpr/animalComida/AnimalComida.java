package com.ifpr.animalComida;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ifpr.animal.Animal;
import com.ifpr.comida.Comida;

@Entity
public class AnimalComida 
{
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn (name = "id_animal", referencedColumnName = "id")
	@ManyToOne()
	private Animal animal;
	
	@JoinColumn (name = "id_comida", referencedColumnName = "id")
	@ManyToOne()
	private Comida comida;

	public int getId() {
		return id;
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}	
}