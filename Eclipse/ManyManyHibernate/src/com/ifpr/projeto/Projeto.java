package com.ifpr.projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.ifpr.funcionarioProjeto.FuncionarioProjeto;

@Entity
@Table (name = "tbProjeto")
public class Projeto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	
	@JoinColumn(name = "id_projeto", referencedColumnName = "id")
	@OneToMany (fetch = FetchType.EAGER)
	private List<FuncionarioProjeto> funcionariosProjetos = new ArrayList<FuncionarioProjeto>();

	public List<FuncionarioProjeto> getFuncionariosProjetos() {
		return funcionariosProjetos;
	}

	public void setFuncionariosProjetos(
			List<FuncionarioProjeto> funcionariosProjetos) {
		this.funcionariosProjetos = funcionariosProjetos;
	}

	public int getId()
	{
		return id;
	}
	
	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public Date getDataFim() 
	{
		return dataFim;
	}

	public void setDataFim(Date dataFim) 
	{
		this.dataFim = dataFim;
	}

	public Date getDataInicio() 
	{
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) 
	{
		this.dataInicio = dataInicio;
	}
}
