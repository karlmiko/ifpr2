package conta;

import java.math.BigDecimal;
import java.util.Date;

public class Extrato 
{
	private int id;
	private Operacoes descricao;
	private Date date;
	private BigDecimal valor;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public Operacoes getDescricao()
	{
		return descricao;
	}
	
	public void setDescricao(Operacoes descricao)
	{
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() 
	{
		return valor;
	}
	
	public void setValor(BigDecimal valor) 
	{
		this.valor = valor;
	}	
}
