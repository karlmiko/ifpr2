package ifpr.main;

import ifpr.console.Console;
import ifpr.pessoa.Usuario;
import ifpr.pessoa.gerenciar.GerenciarUsuario;

import java.util.List;

public class Main 
{
	private final int INSERT = 1;
	private final int LIST = 2;
	private final int UPDATE = 3;
	private final int DELETE = 4;
	private final int EXIT = 5;
	
	private GerenciarUsuario gerUsuario;
	private Console console;
	
	public Main() 
	{
		gerUsuario = new GerenciarUsuario();
		console = new Console();
	}
	
	public static void main(String[] args) 
	{	
		new Main().executar();
	}
	
	public void executar()
	{		
		int opcaoUsuario;
		
		do
		{
			showMenu();
			System.out.print("OPTION_________________");
			opcaoUsuario = console.readInt();
			
			if (opcaoUsuario == INSERT)
			{
				cadastrar();
			}
			if (opcaoUsuario == LIST)
			{
				listar();
			}
			if (opcaoUsuario == UPDATE)
			{
				alterar();
			}
			if (opcaoUsuario == DELETE)
			{
				deletar();
			}

		} while (opcaoUsuario != EXIT);
	}
	
	private void listar()
	{
		List<Usuario> usuarios = gerUsuario.getUsuarios();
		
		for (Usuario usuario : usuarios) 
		{
			System.out.println("________________________");
			System.out.println("ID: " + usuario.getId());
			System.out.println("NOME: " + usuario.getNome());
			System.out.println("LOGIN: " + usuario.getLogin());
			System.out.println("SENHA: " + usuario.getSenha());
		}
		
		System.out.println("________________________");	
	}
	
	private void cadastrar()
	{
		Usuario usuario = new Usuario();
		
		String nome = console.readLine("NAME: ");
		usuario.setNome(nome);
		String login = console.readLine("LOGIN: ");
		usuario.setLogin(login);
		String senha = console.readLine("PASSWORD: ");
		usuario.setSenha(senha);
		
		gerUsuario.cadastrar(usuario);
	}
	
	private void alterar()
	{
		List<Usuario> usuarios = gerUsuario.getUsuarios();
		String nomeAalterar = console.readLine("INSERT THE NAME:");

		boolean thereIs = false;
		
		for (Usuario usuario : usuarios) 
		{
			String nomeUsuario = usuario.getNome();			
			int igualdade = nomeUsuario.compareTo(nomeAalterar);
			
			if (igualdade == 0)
			{
				String nome = console.readLine("NEW NAME: ");
				usuario.setNome(nome);
				String login = console.readLine("NEW LOGIN: ");
				usuario.setLogin(login);
				String senha = console.readLine("NEW PASSWORD: ");
				usuario.setSenha(senha);	
				gerUsuario.alterar(usuario);
				System.out.println("USER UPDATED");
				thereIs = true;
				break;
			}	
		}
		
		if (thereIs == false)
		{
			System.out.println("USER NOT FOUND");
		}
	}
	
	private void deletar()
	{
		List<Usuario> usuarios = gerUsuario.getUsuarios();
		String nomeAdeletar = console.readLine("INSERT THE NAME:");
		boolean thereIs = false;
		
		for (Usuario usuario : usuarios) 
		{
			String nomeUsuario = usuario.getNome();			
			int igualdade = nomeUsuario.compareTo(nomeAdeletar);
			
			if (igualdade == 0)
			{	
				gerUsuario.remover(usuario);
				System.out.println("USER DELETED");
				thereIs = true;
				break;
			}	
		}
		
		if (thereIs == false)
		{
			System.out.println("USER NOT FOUND");
		}
	}
	
	private void showMenu()
	{
		System.out.println("__________MENU__________");
		System.out.println("INSERT_________________1");
		System.out.println("LIST___________________2");
		System.out.println("UPDATE_________________3");
		System.out.println("DELETE_________________4");
		System.out.println("EXIT___________________5");
	}
}
