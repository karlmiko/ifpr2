package ifpr.main;

import java.util.ArrayList;
import java.util.List;

import ifpr.cartao.Cartao;
import ifpr.cartao.CartaoAniversario;
import ifpr.cartao.CartaoDiaNamorados;
import ifpr.cartao.CartaoNatal;
import ifpr.console.Console;
import ifpr.console.Singleton;

public class Main 
{		
	private final int MSG_NATAL = 1;
	private final int MSG_DDN = 2;
	private final int MSG_ANIVER = 3;
	private final int MOSTRAR_MSGS = 4;
	private final int SAIR= 5;
	
	private Console console;
	private List <Cartao> cartoes;
	
	public Main()
	{
		cartoes = new ArrayList<Cartao>();
		console = Singleton.getInstance();
	}
	
	public static void main (String [] args)
	{
		new Main().executar();
	}
	
	public void executar()
	{		
		int OPCAO = 0;
		
		while (OPCAO != SAIR)
		{
			console.printMessage("1 - Nova mensagem de Natal.");
			console.printMessage("2 - Nova mensagem de Dia dos namorados.");
			console.printMessage("3 - Nova mensagem de Anivers�rio.");
			console.printMessage("4 - Mostrar mensagens.");
			console.printMessage("5 - Sair.");
			OPCAO = console.readInt("Opcao: ");
			
			if (OPCAO == MSG_NATAL)
			{
				novaMsgNatal();
			}	
			if (OPCAO == MSG_DDN )
			{
				novaMsgDiaNamorados();
			}
			if (OPCAO == MSG_ANIVER)
			{
				novaMsgAniversario();
			}
			
			if (OPCAO == MOSTRAR_MSGS)
			{	
				listarMensagens();
			}
		}
	}
	
	private void novaMsgNatal()
	{
		Cartao natal = new CartaoNatal();
		natal.lerInformacoes();
		cartoes.add(natal);
	}
	
	private void novaMsgDiaNamorados()
	{
		Cartao diaNamorados = new CartaoDiaNamorados();
		diaNamorados.lerInformacoes();
		cartoes.add(diaNamorados);
	}

	private void novaMsgAniversario()
	{
		Cartao aniversario = new CartaoAniversario();
		aniversario.lerInformacoes();
		cartoes.add(aniversario);
	}
	
	private void listarMensagens()
	{
		System.out.println();
		
		for (Cartao cartao : cartoes) 
		{
			console.printMessage("Remetente: " + cartao.getRemetente());
			console.printMessage("Destinat�rio: " + cartao.getDestinatario());
			cartao.mostrarMensagem();
			System.out.println();
		}
	}
}
