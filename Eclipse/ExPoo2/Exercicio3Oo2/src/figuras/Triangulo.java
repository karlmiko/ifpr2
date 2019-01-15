package figuras;

public class Triangulo {
	
	private double altura;
	private double base;
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
	
	public double getAltura() {
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

	private double area = (altura * base)/2;
	
}
