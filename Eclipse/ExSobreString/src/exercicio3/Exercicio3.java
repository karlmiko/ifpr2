package exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio3
{
	public static void main(String []args)
	{
		List<Character> listaLetrasCadeia = new ArrayList<Character>();
		Scanner leitor = new Scanner (System.in);
		
		System.out.print("Frase ou palavra: ");
		String cadeiaLetras = leitor.nextLine();
		
		int tamanhoCadeia = cadeiaLetras.length();
		
		for (int i = 0; i < (tamanhoCadeia-1); i++)
		{	
			Character letra = cadeiaLetras.charAt(i);
			
			if (!listaLetrasCadeia.contains(letra))
			{
				listaLetrasCadeia.add(letra);	
				int aparicoes = 0;
				
				for (int j = 0; j < (tamanhoCadeia-1); j++)
				{
					if(letra == cadeiaLetras.charAt(j))
					{
						aparicoes++;
					}
				}
				
				System.out.println("A letra \"" + letra + "\" aparece " + aparicoes + " vez(es).");
			}
		}
		
		leitor.close();
	}
}