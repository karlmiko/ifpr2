package veiculo;

import java.math.BigDecimal;

public class Veiculo 
{
	private String marca;
	private String modelo;
	private int id;
	private String nome;
	private Double preco;
	
	public String getMarca() 
	{
		return marca;
	}
	
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	
	public String getModelo() 
	{
		return modelo;
	}
	
	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public BigDecimal getPreco() 
	{
		return BigDecimal.valueOf(preco.intValue());
	}
	
	public void setPreco(Double preco) 
	{
		this.preco = preco;
	}
}
