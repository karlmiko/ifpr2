package capitulo1;

import java.util.Scanner;

public class Exercicio17 
{
	public static void main(String[] args) 
	{
		Scanner leitor = new Scanner (System.in);
		
		String opcoes[] = {"1-Fim", "2-Cadastro", "3-Consulta"};
		
		System.out.println("Menu Principal");
		System.out.println("1-Fim   2-Cadastro   3-Consulta");
		
		System.out.print("Opcão: ");
		int opcao = leitor.nextInt();
		
		opcao--;
		
		if (opcao < 0 || opcao > 2)
		{
			System.out.println("ERRO: Opcão inválida");
		}
		else
		{
			System.out.println(opcoes[opcao]);
		}
	
		leitor.close();
	}
}
