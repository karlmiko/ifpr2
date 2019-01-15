package capitulo1;

import java.util.Scanner;

public class Exercicio11
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		int multiplicacaoValores = 1;
		
		for (int i = 1; i < 4; i++)
		{
			System.out.print("Valor " + i + " = ");
			int valor = leitor.nextInt();
			multiplicacaoValores = multiplicacaoValores * valor;
		}
		
		float mediaGeometrica = (float) Math.cbrt(multiplicacaoValores);
		
		System.out.println("Media geometrica = " + mediaGeometrica);
		
		leitor.close();
	}
}
