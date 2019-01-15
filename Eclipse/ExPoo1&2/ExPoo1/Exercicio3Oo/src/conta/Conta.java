package conta;

import java.math.BigDecimal;

public class Conta 
{	
	private String dataLeitura;
	private String dataVencimento;
	private BigDecimal preco;
	private int numeroLeitura;
	private int mesReferente;

	public String getDataLeitura() 
	{
		return dataLeitura;
	}

	public void setDataLeitura(String dataLeitura) 
	{
		this.dataLeitura = dataLeitura;
	}

	public String getDataVencimento() 
	{
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) 
	{
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getPreco() 
	{
		return preco;
	}

	public void setPreco(BigDecimal preco) 
	{
		this.preco = preco;
	}

	public int getNumeroLeitura() 
	{
		return numeroLeitura;
	}

	public void setNumeroLeitura(int numeroLeitura) 
	{
		this.numeroLeitura = numeroLeitura;
	}

	public int getMesReferente() 
	{
		return mesReferente;
	}

	public void setMesReferente(int mesReferente) 
	{
		this.mesReferente = mesReferente;
	}
}