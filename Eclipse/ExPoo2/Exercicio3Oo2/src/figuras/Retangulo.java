package figuras;

public class Retangulo 
{
	private double altura;
	private double comprimento;
	
	private double area = altura * comprimento;
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura)
	{
		this.altura = altura;
	}
	
	public double getComprimento() 
	{
		return comprimento;
	}
	
	public void setComprimento(double comprimento)
	{
		this.comprimento = comprimento;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
}
