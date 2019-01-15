package com.ifpr.disciplina;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ifpr.disciplinaAluno.DisciplinaAluno;

@Entity
@Table (name = "tbDisciplina")
public class Disciplina 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_disciplina")
	private int id;
	private String nome;
	
	@JoinColumn(name = "id_disciplina", referencedColumnName = "id")
	@OneToMany (fetch = FetchType.EAGER)
	private List<DisciplinaAluno> disciplinaAluno = new ArrayList<DisciplinaAluno>();
	
	public List<DisciplinaAluno> getDisciplinaAluno() 
	{
		return disciplinaAluno;
	}

	public void setDisciplinaAluno(List<DisciplinaAluno> disciplinaAluno) 
	{
		this.disciplinaAluno = disciplinaAluno;
	}

	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
}