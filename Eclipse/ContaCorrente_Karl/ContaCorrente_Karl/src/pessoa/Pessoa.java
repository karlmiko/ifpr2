 package pessoa;

import conta.ContaCorrente;
import pessoa.endereco.Endereco;

public abstract class Pessoa 
{
	protected int id;
	protected String nome;
	protected int telefone;
	protected Endereco endereco;
	protected ContaCorrente conta;
	protected int rg;
	protected String cpf;
	
	public int getRg() 
	{
		return rg;
	}

	public void setRg(int rg) 
	{
		this.rg = rg;
	}

	public String getCpf() 
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public ContaCorrente getConta() 
	{
		return conta;
	}

	public void setConta(ContaCorrente conta) 
	{
		this.conta = conta;
	}

	public int getTelefone() 
	{
		return telefone;
	}

	public Endereco getEndereco() 
	{
		return endereco;
	}

	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
	}

	public void setTelefone(int telefone) 
	{
		this.telefone = telefone;
	}

	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
}
