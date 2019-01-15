package conta;

import java.math.BigDecimal;
import java.util.List;

public class ContaCorrente 
{
	private String numero;
	private String agencia;
	private BigDecimal saldo;
	private BigDecimal limite;
	private List<Extrato> extrato;
			
	public String getNumero() 
	{
		return numero;
	}
	
	public void setNumero(String numero) 
	{
		this.numero = numero;																																											
	}
	
	public String getAgencia()
	{
		return agencia;
	}
	
	public void setAgencia(String agencia)
	{
		this.agencia = agencia;
	}
	
	public BigDecimal getSaldo() 
	{
		return saldo;
	}
	
	public void setSaldo(BigDecimal saldo) 
	{
		this.saldo = saldo;
	}

	public BigDecimal getLimite() 
	{
		return limite;
	}

	public void setLimite(BigDecimal limite) 
	{
		this.limite = limite;
	}

	public List<Extrato> getExtrato()
	{
		return extrato;
	}

	public void setExtrato(List<Extrato> extrato) 
	{
		this.extrato = extrato;
	}
}
