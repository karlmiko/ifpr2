package proprietario;

import endereco.Endereco;

public class Proprietario 
{
	private String nome;
	private String dataNascimento;
	private int telefoneResidencial;
	private int telefoneCelular;
	private int telefoneComercial;
	private String Sexo;
	private Endereco endereco;
	
	public String getDataNascimento() 
	{
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
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

	public int getTelefoneComercial() 
	{
		return telefoneComercial;
	}

	public void setTelefoneComercial(int telefoneComercial) 
	{
		this.telefoneComercial = telefoneComercial;
	}

	public String getSexo() 
	{
		return Sexo;
	}

	public void setSexo(String sexo)
	{
		Sexo = sexo;
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