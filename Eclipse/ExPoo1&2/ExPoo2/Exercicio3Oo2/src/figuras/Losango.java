package figuras;

public class Losango 
{
	private double base;
	private double altura;
	private double area = (base * altura) / 2;
	
	public double getBase()
	{
		return base;
	}
	
	public void setBase(double base) 
	{
		this.base = base;
	}
	
	public double getAltura()
	{
		return altura;
	}
	
	public void setAltura(double altura) 
	{
		this.altura = altura;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
}
