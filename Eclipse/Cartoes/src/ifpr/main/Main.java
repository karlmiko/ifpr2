package ifpr.main;

import ifpr.cartao.Cartao;
import ifpr.cartao.CartaoAniversario;
import ifpr.cartao.CartaoDiaNamorados;
import ifpr.cartao.CartaoNatal;
import ifpr.console.Console;
import ifpr.console.SingletonConsole;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private List<Cartao> cartoes;
	private Console console;
	
	private static final int NOVA_MENS_NATAL = 1;
	private static final int NOVA_DIA_NAMORADOS = 2;
	private static final int NOVA_ANIVERSARIO = 3;
	private static final int LISTAR_MENSAGENS = 4;
	private static final int SAIR = 5;
	
	public Main() {
		cartoes = new ArrayList<>();
		console = SingletonConsole.getInstance();
	}
	
	public static void main(String[] args) {
		new Main().execute();
	}
	
	public void execute()
	{
		int opcao = 0;
		do
		{
			console.printMessage("1 - Nova mensagem de natal");
			console.printMessage("2 - Nova mensagem de dia dos namorados");
			console.printMessage("3 - Nova mensagem de anivers�rio");
			console.printMessage("4 - Mostrar mensagens");
			console.printMessage("5 - Sair");
			opcao = console.readInt("Escolha uma op��o: ");
			
			if ( opcao == NOVA_MENS_NATAL )
			{
				novaMsgNatal();
			}
			else if ( opcao == NOVA_DIA_NAMORADOS )
			{
				novaMsgDiaNamorados();
			}
			else if ( opcao == NOVA_ANIVERSARIO )
			{
				novaMsgAniversario();
			}
			else if ( opcao == LISTAR_MENSAGENS )
			{
				listarMensagens();
			}
		} while(opcao != SAIR);
	}
	
	private void novaMsgNatal()
	{
		Cartao natal = new CartaoNatal();
		natal.lerDados();
		cartoes.add(natal);
	}
	
	private void novaMsgDiaNamorados()
	{
		Cartao diaNamorados = new CartaoDiaNamorados();
		diaNamorados.lerDados();
		cartoes.add(diaNamorados);
	}

	private void novaMsgAniversario()
	{
		Cartao aniversario = new CartaoAniversario();
		aniversario.lerDados();
		cartoes.add(aniversario);
	}
	
	private void listarMensagens()
	{
		for (Cartao cartao : cartoes) {
			console.printMessage("");
			console.printMessage("Remetente: " + cartao.getRemetente());
			console.printMessage("Destinat�rio: " + cartao.getDestinatario());
			cartao.mostrarMensagem();
			console.printMessage("");
		}
	}
}
