package filmes.locacao;

import java.math.BigDecimal;

public class TabelaPreco 
{
	private String tipo;
	private BigDecimal valor;
	private int tempoDevolucao;
	
	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public BigDecimal getValor() 
	{
		return valor;
	}

	public void setValor(BigDecimal valor) 
	{
		this.valor = valor;
	}

	public int getTempoDevolucao()
	{
		return tempoDevolucao;
	}

	public void setTempoDevolucao(int tempoDevolucao)
	{
		this.tempoDevolucao = tempoDevolucao;
	}	
}
