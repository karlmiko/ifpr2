package capitulo1;

public class Exercicio1
{
	public static void main (String[] args)
	{
		int tempoTotal = 100;
		int materias = 6;
		int tempoCadaMateria = tempoTotal/materias;
		int tempoLivre = tempoTotal%materias;
		
		System.out.println("Tempo para cada matÈria: " + tempoCadaMateria);
		System.out.println("Tempo livre: " + tempoLivre);		
	}
}
