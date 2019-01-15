package pessoa;

public class Juridica extends Pessoa
{
	private String cnpj;
	private int inscricaoEstadual;
	
	public String getCnpj()
	{
		return cnpj;
	}
	
	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}
	
	public int getInscricaoEstadual() 
	{
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(int inscricaoEstadual) 
	{
		this.inscricaoEstadual = inscricaoEstadual;
	}
}
