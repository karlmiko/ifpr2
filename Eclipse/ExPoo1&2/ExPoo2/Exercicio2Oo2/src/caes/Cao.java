package caes;

import caes.controleDeVacina.ControleDeVacinas;
import caes.prontuarioMedico.ProntuarioMedico;

public class Cao 
{
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String raca;
	private ProntuarioMedico prontuarioMedico;
	private ControleDeVacinas controleDeVacina;

	public ProntuarioMedico getProntuarioMedico() 
	{
		return prontuarioMedico;
	}

	public void setProntuarioMedico(ProntuarioMedico prontuarioMedico) 
	{
		this.prontuarioMedico = prontuarioMedico;
	}

	public ControleDeVacinas getControleDeVacina() 
	{
		return controleDeVacina;
	}

	public void setControleDeVacina(ControleDeVacinas controleDeVacina) 
	{
		this.controleDeVacina = controleDeVacina;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getDataNascimento() 
	{
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}
	
	public String getSexo() 
	{
		return sexo;
	}
	
	public void setSexo(String sexo) 
	{
		this.sexo = sexo;
	}
	
	public String getRaca() 
	{
		return raca;
	}
	
	public void setRaca(String raca) 
	{
		this.raca = raca;
	}
}