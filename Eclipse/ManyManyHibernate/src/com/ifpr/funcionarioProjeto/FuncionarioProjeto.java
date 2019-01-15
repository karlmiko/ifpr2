package com.ifpr.funcionarioProjeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.ifpr.funcionario.Funcionario;
import com.ifpr.projeto.Projeto;

@Entity
@Table (name = "tbFuncionarioProjeto")
public class FuncionarioProjeto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn (name = "id_funcionario", referencedColumnName = "id")
	@ManyToOne()
	private Funcionario funcionario;
	
	@JoinColumn (name = "id_projeto", referencedColumnName = "id")
	@ManyToOne()
	private Projeto projeto;
	
	public int getId() 
	{
		return id;
	}
	
	public Funcionario getFuncionario()
	{
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}
	
	public Projeto getProjeto() 
	{
		return projeto;
	}
	
	public void setProjeto(Projeto projeto)
	{
		this.projeto = projeto;
	}
}
