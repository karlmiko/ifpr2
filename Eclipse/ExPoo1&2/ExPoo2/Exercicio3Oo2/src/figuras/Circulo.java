package figuras;

public class Circulo 
{
	private double raio;
	
	public double getRaio() {
		return raio;
	}

	public double setRaio(double raio) {
		return this.raio = raio;
	}
	
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	private double area = 3.14 * (raio * raio);
}

