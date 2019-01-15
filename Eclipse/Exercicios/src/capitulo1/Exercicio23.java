package capitulo1;

import java.util.Scanner;

public class Exercicio23
{
	public static void main (String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		String mencoes[] = {"SR", "II", "MI", "MM", "MS", "SS"};
		Integer notasMencoes[] = {0, 3, 5, 7, 9, 10};
		
		System.out.print("Nota do Aluno: ");
		float nota = leitor.nextFloat();
		
		for (int i = 0; i < 7; i++)
		{
			int inicioNotaMencao = notasMencoes[i];
			
			if (nota <= inicioNotaMencao)
			{
				System.out.println("Mencão: " + mencoes[i]);
				break;
			}
		}
		
		leitor.close();
	}
}