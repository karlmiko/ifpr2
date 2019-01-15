package pessoa;

import java.util.Date;

public class Fisica extends Pessoa
{
	private Date dataNascimento;
	private Sexo sexo;
	
	public Date getDataNascimento() 
	{
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}
	
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	public Sexo getSexo() 
	{
		return sexo;
	}

	public void setSexo(Sexo sexo) 
	{
		this.sexo = sexo;
	}
}
