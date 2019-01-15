package main;

import java.util.Scanner;

import figuras.Circulo;
import figuras.Losango;
import figuras.Quadrado;
import figuras.Retangulo;
import figuras.Triangulo;

public class Main 
{
	public static void main (String [] args)
	{
		Scanner reader = new Scanner (System.in);

		while (true)
		{	
			System.out.println ("1 - Círculo   /  2 - Quadrado");
			System.out.println ("3 - Retângulo /  4 - Losango");
			System.out.println ("5 - Triângulo /  9 - Sair");
			System.out.print ("Digite número e pressione enter: ");
			
			int opcao = reader.nextInt();
			
			switch (opcao)
			{
				case 1:
				{			
					Circulo circulo = new Circulo();
					System.out.print ("Digite o raio e pressione enter: ");
					circulo.setRaio(reader.nextDouble());
					circulo.setArea((circulo.getRaio() * circulo.getRaio()) * 3.14);
					System.out.println ("Area do círculo: " + circulo.getArea());
					break;
					
				}
				case 2:
				{			
					Quadrado quadrado = new Quadrado();
					System.out.print ("Digite o lado e pressione enter: ");
					quadrado.setLado(reader.nextDouble());
					quadrado.setArea(quadrado.getLado() * 2);
					System.out.println ("Area do quadrado: " + quadrado.getArea());
					break;
				}
				case 3:
				{			
					Retangulo retangulo = new Retangulo();
					System.out.print ("Digite a base e pressione enter: ");
					retangulo.setAltura(reader.nextDouble());
					System.out.print ("Digite a altura e pressione enter: ");
					retangulo.setComprimento(reader.nextDouble());
					retangulo.setArea(retangulo.getComprimento() * retangulo.getAltura());
					System.out.println ("Area do retangulo: " + retangulo.getArea());
					break;
				}
				case 4:
				{			
					Losango losango = new Losango();
					System.out.print ("Digite a base e pressione enter: ");
					losango.setAltura(reader.nextDouble());
					System.out.print ("Digite a altura e pressione enter: ");
					losango.setBase(reader.nextDouble());
					losango.setArea((losango.getBase() * losango.getAltura()) / 2);
					System.out.println ("Area do losango: " + losango.getArea());
					break;
					
				}
				case 5:
				{			
					Triangulo triangulo = new Triangulo();
					System.out.print ("Digite a base e pressione enter: ");
					triangulo.setAltura(reader.nextDouble());
					System.out.print ("Digite a altura e pressione enter: ");
					triangulo.setBase(reader.nextDouble());
					triangulo.setArea((triangulo.getBase() * triangulo.getAltura()) / 2);
					System.out.println ("Area do triângulo: " + triangulo.getArea());
					break;
				}
				case 9:
				{			
					return;
				}
			}
		}
	}
}	