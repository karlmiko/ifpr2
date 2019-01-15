package capitulo1;

import java.util.Scanner;

public class Exercicio13
{
	public static void main (String[] args)
	{
		Scanner leitor = new Scanner (System.in);
			
		System.out.print("Valor 1: ");
		int valor1 = leitor.nextInt();
		System.out.print("Valor 2: ");
		int valor2 = leitor.nextInt();
		
		int soma = valor1 + valor2;
		int diferenca = valor1 - valor2;
		int multiplicacao = valor1 * valor2;
		int quociente = valor1 / valor2;
		
		System.out.println("Soma: " + soma + " Diferenca: " +
		diferenca + " Multiplicacao: " + multiplicacao +
		" Quociente: " + quociente);
		
		leitor.close();
		
		
	}
}
