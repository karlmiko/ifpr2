package caes.prontuarioMedico;

import caes.prontuarioMedico.exame.Exames;
import veterinario.Veterinario;

public class ProntuarioMedico
{
	private String dataAtendimento;
	private String quiexas;
	private String procedimentoRealizado;
	private String medicamentosMinistrados;
	private Veterinario veterinarioResponsavel;
	private Exames exames;
	
	public Veterinario getVeterinarioResponsavel() 
	{
		return veterinarioResponsavel;
	}

	public void setVeterinarioResponsavel(Veterinario veterinarioResponsavel)
	{
		this.veterinarioResponsavel = veterinarioResponsavel;
	}

	public Exames getExames() 
	{
		return exames;
	}

	public void setExames(Exames exames) 
	{
		this.exames = exames;
	}

	public String getDataAtendimento() 
	{
		return dataAtendimento;
	}
	
	public void setDataAtendimento(String dataAtendimento) 
	{
		this.dataAtendimento = dataAtendimento;
	}
	
	public String getQuiexas() 
	{
		return quiexas;
	}
	
	public void setQuiexas(String quiexas) 
	{
		this.quiexas = quiexas;
	}
	
	public String getProcedimentoRealizado() 
	{
		return procedimentoRealizado;
	}
	
	public void setProcedimentoRealizado(String procedimentoRealizado)
	{
		this.procedimentoRealizado = procedimentoRealizado;
	}
	
	public String getMedicamentosMinistrados() 
	{
		return medicamentosMinistrados;
	}
	
	public void setMedicamentosMinistrados(String medicamentosMinistrados) 
	{
		this.medicamentosMinistrados = medicamentosMinistrados;
	}
}