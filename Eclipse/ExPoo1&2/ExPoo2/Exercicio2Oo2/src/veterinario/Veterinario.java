package veterinario;

import endereco.Endereco;

public class Veterinario
{
	private String nome;
	private int numeroCrv;
	private int telefoneResidencial;
	private int telefoneCelular;
	private Endereco endereco;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public int getNumeroCrv() 
	{
		return numeroCrv;
	}
	
	public void setNumeroCrv(int numeroCrv) 
	{
		this.numeroCrv = numeroCrv;
	}
	
	public int getTelefoneResidencial()
	{
		return telefoneResidencial;
	}
	
	public void setTelefoneResidencial(int telefoneResidencial)
	{
		this.telefoneResidencial = telefoneResidencial;
	}
	
	public int getTelefoneCelular()
	{
		return telefoneCelular;
	}
	
	public void setTelefoneCelular(int telefoneCelular)
	{
		this.telefoneCelular = telefoneCelular;
	}
	
	public Endereco getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}
}