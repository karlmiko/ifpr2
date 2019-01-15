package gerenciamento;

import java.util.Date;
import java.util.List;

import material.MaterialDeApoio;

import funcionario.Funcionario;

import reserva.Reserva;
import sala.Sala;

public class Gerenciamento
{
	public void realocar (List <Reserva> reserva, Date dataInicio,
			Date dataFim, Funcionario funcionario)
	{
		
	}
	
	public void reservarSala (List <Reserva> reserva, Date dataInicio,
			Date dataFim, Funcionario funcionario, Sala sala)
	{
		
	}
	
	public void reservarMaterialApoio (List <Reserva> reserva, 
			Date dataInicio, Date dataFim, 
			Funcionario funcionario, Sala sala,
			MaterialDeApoio materialDeApoio)
	{
		
	}
	
	public List <Sala> sala (Date dataInicio, Date dataFim)
	{
		return null;	
	}
}