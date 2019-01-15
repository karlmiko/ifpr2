package com.ifpr.curso;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ifpr.aluno.Aluno;

@Entity
@Table(name = "tbCurso")
public class Curso 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_curso")
	private int id;
	private String nome;

	@JoinColumn(name = "id_curso", referencedColumnName = "id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Aluno> alunosNoCurso = new ArrayList<Aluno>();
	
	public List<Aluno> getAlunosNoCurso() 
	{
		return alunosNoCurso;
	}

	public void setAlunosNoCurso(List<Aluno> alunosNoCurso) 
	{
		this.alunosNoCurso = alunosNoCurso;
	}

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
}
