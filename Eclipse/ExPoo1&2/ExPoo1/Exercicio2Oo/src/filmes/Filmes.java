package filmes;

public class Filmes 
{
	private String titulo;
	private String genero;
	private int duracaoMinutos;
	private int qtdCopias;
	
	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getGenero() 
	{
		return genero;
	}

	public void setGenero(String genero) 
	{
		this.genero = genero;
	}

	public int getDuracaoMinutos() 
	{
		return duracaoMinutos;
	}

	public void setDuracaoMinutos(int duracaoMinutos) 
	{
		this.duracaoMinutos = duracaoMinutos;
	}

	public int getQtdCopias()
	{
		return qtdCopias;
	}

	public void setQtdCopias(int qtdCopias) 
	{
		this.qtdCopias = qtdCopias;
	}
}