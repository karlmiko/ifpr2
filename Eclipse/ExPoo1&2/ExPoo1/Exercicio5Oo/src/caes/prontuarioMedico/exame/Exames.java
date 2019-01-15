package caes.prontuarioMedico.exame;

import endereco.Endereco;
import veterinario.Veterinario;

public class Exames
{
	private String nome;
	private String data;
	private Endereco endereco;
	private Veterinario veterinarioResponsavel;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getData() 
	{
		return data;
	}
	
	public void setData(String data) 
	{
		this.data = data;
	}
	
	public Endereco getEndereco() 
	{
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
	}
	
	public Veterinario getVeterinarioResponsavel() 
	{
		return veterinarioResponsavel;
	}
	
	public void setVeterinarioResponsavel(Veterinario veterinarioResponsavel) 
	{
		this.veterinarioResponsavel = veterinarioResponsavel;
	}
}