package capitulo1;

import java.util.Scanner;

public class Exercicio15
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		System.out.print("Idade: ");
		int idade = leitor.nextInt();
		int somaIdades = 0;
		
		for (int i = 0; i <= idade; i++)
		{
			somaIdades = somaIdades + i;			
		}
		
		System.out.println("Soma das idades: " + somaIdades);
		
		leitor.close();
	}
}