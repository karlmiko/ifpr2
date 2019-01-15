package ifpr.main;

import ifpr.computador.Computador;
import ifpr.computador.gerenciarComputador.GerenciarComputador;
import ifpr.console.Console;

import java.util.List;

public class Main 
{	
	private final int INSERT = 1;
	private final int REMOVE = 2;
	private final int UPDATE = 3;
	private final int LIST = 4;
	private final int EXIT = 5;
	private int OPTION;
	
	Console console = new Console();
	GerenciarComputador gerenciador = new GerenciarComputador();
	
	public static void main (String [] args)
	{
		new Main().executar();
	}
	
	public void executar()
	{		
		while (OPTION != EXIT)
		{
			mostraMenu();
			OPTION = console.readInt("Opcao: ");
			
			if (OPTION == INSERT)
			{
				inserirComputador();
			}
			
			if (OPTION == REMOVE)
			{
				removerComputador();
			}
			
			if (OPTION == UPDATE)
			{
				atualizarComputador();
			}
			
			if (OPTION == LIST)
			{
				listarComputadores();
			}
		}
	}
	
	public void mostraMenu()
	{
		console.printMessage("1 - Inserir.");
		console.printMessage("2 - Remover.");
		console.printMessage("3 - Atualizar.");
		console.printMessage("4 - Listar.");
		console.printMessage("5 - Sair.");
	}
	
	public void inserirComputador()
	{
		Computador pc = new Computador();
		System.out.println("");
		pc.setMarca(console.readLine("Marca do computador: "));
		pc.setQtdMemoriaRam(console.readInt("Quantidade de memória ram: "));
		System.out.println("");
		gerenciador.inserir(pc);
	}
	
	public void removerComputador()
	{
		System.out.println("");
		int idDeletar = console.readInt("ID do computador a ser removido: ");
		List<Computador> computadores = gerenciador.retornaLista();
		
		for (Computador computador : computadores) 
		{
			if (idDeletar == computador.getId())
			{
				gerenciador.remover(computador);
				console.printMessage("Computador removido!");
				System.out.println("");
				break;
			}
		}
	}
	
	public void atualizarComputador()
	{
		System.out.println("");
		int idAtualizar = console.readInt("ID do computador a ser atualizado: ");
		List<Computador> computadores = gerenciador.retornaLista();
		
		for (Computador computador : computadores) 
		{
			if (computador.getId() == idAtualizar)
			{
				String marca = console.readLine("Nova marca: ");
				computador.setMarca(marca);
				int MemoriaRam = console.readInt("Nova quantidade de memória ram: ");
				System.out.println("");
				computador.setQtdMemoriaRam(MemoriaRam);
				gerenciador.atualizar(computador);
				break;
			}
		}
	}
	
	public void listarComputadores()
	{
		List <Computador> Lista = gerenciador.retornaLista();
		
		for (Computador pc : Lista) 
		{
			System.out.println("");
			console.printMessage("Id: " + pc.getId());
			console.printMessage("Marca: " + pc.getMarca());
			console.printMessage("Quantidade de memória ram: " + pc.getQtdMemoriaRam());
			System.out.println("");
		}
	}
}
