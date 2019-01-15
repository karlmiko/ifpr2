package capitulo1;

import java.util.Scanner;

public class Exercicio12
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		int somaValores = 0;
		int dividendo = 0;
		
		for (int i = 1; i < 4; i++)
		{
			System.out.print("Valor " + i + " = ");
			int valor = leitor.nextInt();
			somaValores = (valor*i) + somaValores;
			dividendo = dividendo + i;
		}
		
		float mediaPonderada = somaValores/dividendo;
		
		System.out.println("Media ponderada: " + mediaPonderada);
		
		leitor.close();
	}
}
