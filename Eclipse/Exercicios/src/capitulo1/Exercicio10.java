package capitulo1;

import java.util.Scanner;

public class Exercicio10
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		int somatoriaNotas = 0;
		int nota;
		
		for (int i = 1; i < 4; i++)
		{
			System.out.print("Nota " + i + " = ");
			nota = leitor.nextInt();
			somatoriaNotas = somatoriaNotas + nota;
		}
		
		int numeroNotas = 3;
		int mediaAritmetica = somatoriaNotas / numeroNotas;
		
		System.out.println("MÈdia aritmetica das notas: " + mediaAritmetica);
		
		leitor.close();
	}
}
