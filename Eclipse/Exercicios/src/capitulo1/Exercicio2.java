package capitulo1;

public class Exercicio2
{
	public static void main(String[] args)
	{
		for (int i = 3; i < 6; i++)
		{
			int metrosMadeira = i;
			
			int centimetrosMadeira = metrosMadeira*100;
        	int cadaPedaco = 45;
        	int	totalPedacos = centimetrosMadeira / cadaPedaco;
        	int sobraMadeira = centimetrosMadeira % cadaPedaco;
        
        	System.out.println(metrosMadeira + " metros = " + totalPedacos + " pedacos de 45 centÌmetros.");
        	System.out.println("Sobra: " + sobraMadeira + " centimetros.");
		}                     
	}
}
