package main;

import console.Console;


public class Main {
	
	Console console = new Console();
	GerenciarPessoa gerenciarPessoa = new GerenciarPessoa();
	
	public static void main (String [] args)
	{
		new Main().executar();
	}
	
	public void executar()
	{
		console.printMessage("Controle de usu�rios da Empresa");
		console.printMessage("-------------------------------");
		console.printMessage("		1- Cadastrar usu�rio");
		console.printMessage("		2 - Deletar usu�rio");
		console.printMessage("		3 - Listar usu�rios");
		console.printMessage("		4 - Alterar usu�rio");
		console.printMessage("		5 - Sair");
		console.printMessage("-------------------------------");
		console.printMessage("Op��o: ");
		int opcao = console.readInt();
		
		switch (opcao) {
		
			case 1: newUser();
			break;
			case 2: deletar
			break;
			case 3: Listar
			break;
			case 4: alterar
			break;
		}
	}
	
	private void newUser();
	{
		Pessoa pessoa;
		pessoa.setId()
	}
	

}
