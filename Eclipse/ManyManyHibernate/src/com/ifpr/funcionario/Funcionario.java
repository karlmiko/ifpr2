package com.ifpr.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.ifpr.funcionarioProjeto.FuncionarioProjeto;
import com.ifpr.pessoa.Pessoa;

@Entity
@Table (name = "tbFuncionario")
public class Funcionario extends Pessoa
{
	private int rg;
	private int cpf;
	
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id")
	@OneToMany (fetch = FetchType.EAGER)
	private List<FuncionarioProjeto> funcionariosProjetos = new ArrayList<FuncionarioProjeto>();
	
	public List<FuncionarioProjeto> getFuncionariosProjetos() 
	{
		return funcionariosProjetos;
	}

	public void setFuncionariosProjetos(
			List<FuncionarioProjeto> funcionariosProjetos) 
	{
		this.funcionariosProjetos = funcionariosProjetos;
	}

	public int getRg() 
	{
		return rg;
	}
	
	public void setRg(int rg)
	{
		this.rg = rg;
	}
	
	public int getCpf() 
	{
		return cpf;
	}
	
	public void setCpf(int cpf) 
	{
		this.cpf = cpf;
	}
	
	public void mostrarAtributos()
	{
		System.out.println("CPF: " + this.getCpf());
		System.out.println("RG: " + this.getRg());
	}
}
