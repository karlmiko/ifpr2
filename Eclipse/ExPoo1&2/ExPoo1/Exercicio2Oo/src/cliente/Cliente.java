package cliente;

public class Cliente
{
	private String codigo;
	private String rg;
	private String telefone;
	private String endereco;
	
	public String getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getRg() 
	{
		return rg;
	}

	public void setRg(String rg) 
	{
		this.rg = rg;
	}

	public String getTelefone() 
	{
		return telefone;
	}

	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}

	public String getEndereco() 
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
}