package com.ifpr.main;

import java.util.List;
import com.ifpr.animal.Animal;
import com.ifpr.animal.dao.AnimalDaoImpl;
import com.ifpr.animalComida.AnimalComida;
import com.ifpr.animalComida.dao.AnimalComidaDaoImpl;
import com.ifpr.brinquedo.Brinquedo;
import com.ifpr.comida.Comida;
import com.ifpr.comida.dao.ComidaDaoImpl;
import com.ifpr.console.Console;
import com.ifpr.entityManager.EntitySingleton;

public class Main 
{
	private AnimalDaoImpl gerenciadorDeAnimais = new AnimalDaoImpl(Animal.class);
	private ComidaDaoImpl gerenciadorDeComidas = new ComidaDaoImpl(Comida.class);
	private AnimalComidaDaoImpl relacionamento = new AnimalComidaDaoImpl(AnimalComida.class);
	private Console console = new Console();
	
	public static void main (String [] args)
	{
		new Main().executar();
	}
	
	public void executar()
	{
		listaAnimalComida();
		
		EntitySingleton.closeEntityManager();
	}
	
	public void cadastrarAnimal()
	{
		Animal animal = new Animal();
		animal.setEspecie(console.readLine("Especie: "));
		Brinquedo brinquedo = new Brinquedo();
		brinquedo.setNome(console.readLine("Nome do brinquedo predileto: "));
		animal.setBrinquedo(brinquedo);
		gerenciadorDeAnimais.save(animal);
	}
	
	public void listaAnimalComida()
	{
		List<AnimalComida> lista = gerenciadorDeAnimais.findById(
				console.readInt("Id do animal: ")).getComidasFavoritas();
		
		int clas = 1;
		for (AnimalComida animalComida : lista) 
		{
			System.out.println(clas + " comida favorita: " + animalComida.getComida().getNome());
		}
	}
	
	public void listarAnimais()
	{
		
	}
	
	public void alterarAnimal()
	{
		
	}
	
	public void excluirAnimal()
	{
		
	}
	
	public void cadastrarComida()
	{
		Comida comida = new Comida();
		comida.setNome(console.readLine("Comida: "));
		gerenciadorDeComidas.save(comida);
	}
	
	public void listarComida()
	{
		
	}
	
	public void alterarComida()
	{
		
	}
	
	public void excluirComida()
	{
		
	}
	
	public void cadastrarRelacao()
	{
		AnimalComida relacao = new AnimalComida();
		relacao.setAnimal(gerenciadorDeAnimais.findById(console.readInt("Id do animal: ")));
		relacao.setComida(gerenciadorDeComidas.findById(console.readInt("Id da comida: ")));
		relacionamento.save(relacao);
	}
}