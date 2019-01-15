package ifpr.main;

import java.util.List;

import ifpr.cartao.Cartao;
import ifpr.cartao.gerenciarCartao.GerenciarCartao;
import ifpr.console.Console;

public class Main 
{
	private final int CHRISTMAS = 1;
	private final int VALENTINES = 2;
	private final int BIRTHDAY = 3;
	private final int LIST = 4;
	private final int EXIT = 5;
	private Console console;
	private GerenciarCartao gerenciador;
	
	public Main()
	{
		console = new Console();
		gerenciador = new GerenciarCartao();
	}
	
	public static void main (String [] args)
	{
		new Main().execute();
	}
	
	public void execute()
	{
		int option = 0;
		
		do
		{
			showMenu();
			option = console.readInt("Escolha o número e 'ENTER' ........... ");
			
			if (option == CHRISTMAS)
			{
				novoCartao("Natal");
			}
			if (option == VALENTINES)
			{
				novoCartao("Dia dos namorados");
			}
			if (option == BIRTHDAY)
			{
				novoCartao("Aniversário");
			}
			if (option == LIST)
			{
				retornaListaCartoes();
			}
			
		} while (option != EXIT);
	}
	
	private void retornaListaCartoes() 
	{
		List <Cartao> cartoes = gerenciador.listarCartoes();
		System.out.println();
		
		for (Cartao cartao : cartoes) 
		{
			console.printMessage("Id: " + cartao.getId_cartao());
			console.printMessage("Tipo da mensagem: " + cartao.getTipo());
			console.printMessage("Remetente: " + cartao.getRemetente());
			console.printMessage("Destinatario: " + cartao.getDestinatario());
			console.printMessage("Mensagem: " + cartao.getTexto());
			System.out.println();
		}
	}

	private void novoCartao(String tipo) 
	{
		Cartao cartao = new Cartao();
		cartao.setTipo(tipo);
		cartao.setDestinatario(console.readLine("Destinatário: "));
		cartao.setRemetente(console.readLine("Remetente: "));
		cartao.setTexto(console.readLine("Mensagem: "));
		gerenciador.inserirCartao(cartao);
	}

	public void showMenu()
	{
		console.printMessage("Mande uma mensagem para quem você quiser!");
		System.out.println();
		console.printMessage("Mensagem de natal ............. aperte 1!");
		console.printMessage("Mensagem de dia dos namorados . aperte 2!");
		console.printMessage("Mensagem de aniversário ....... aperte 3!");
		console.printMessage("Ver todas as mensagens ........ aperte 4!");
		console.printMessage("Sair .......................... aperte 5!");
	}
}
