package reserva;

import java.util.Date;

import material.MaterialDeApoio;
import funcionario.Funcionario;
import sala.Sala;

public class Reserva 
{
	private Date dataInicio;
	private Date dataFim;
	private Sala sala;
	private Funcionario funcionario;
	private String assunto;
	private MaterialDeApoio materialDeApoio;

	public MaterialDeApoio getMaterialDeApoio() 
	{
		return materialDeApoio;
	}

	public void setMaterialDeApoio(MaterialDeApoio materialDeApoio) 
	{
		this.materialDeApoio = materialDeApoio;
	}

	public String getAssunto() 
	{
		return assunto;
	}

	public void setAssunto(String assunto)
	{
		this.assunto = assunto;
	}

	public Date getDataInicio()
	{
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) 
	{
		this.dataInicio = dataInicio;
	}

	public Date getDataFim()
	{
		return dataFim;
	}

	public void setDataFim(Date dataFim)
	{
		this.dataFim = dataFim;
	}

	public Sala getSala()
	{
		return sala;
	}

	public void setSala(Sala sala) 
	{
		this.sala = sala;
	}

	public Funcionario getFuncionario() 
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}
}
