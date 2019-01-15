package com.ifpr.cliente;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ifpr.pessoa.Pessoa;

@Entity
@Table (name = "tbTable")
public class Cliente extends Pessoa
{	
	private int cnpj;
	private int inscricaoEst;
	
	public int getCnpj() 
	{
		return cnpj;
	}
	
	public void setCnpj(int cnpj) 
	{
		this.cnpj = cnpj;
	}
	
	public int getInscricaoEst() 
	{
		return inscricaoEst;
	}
	
	public void setInscricaoEst(int inscricaoEst) 
	{
		this.inscricaoEst = inscricaoEst;
	}
	
	public void mostrarAtributos()
	{
		System.out.println("CNPJ: " + this.getCnpj());
		System.out.println("Inscricao estadual: " + this.getInscricaoEst());
	}
}

