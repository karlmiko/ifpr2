package com.ifpr.disciplinaAluno;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ifpr.aluno.Aluno;
import com.ifpr.disciplina.Disciplina;

@Entity
@Table (name="tbDisciplinaAluno")
public class DisciplinaAluno 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column (name = "id_disciplinaAluno")
	private int id;
	
	@JoinColumn (name = "id_aluno", referencedColumnName = "id")
	@ManyToOne()
	private Aluno aluno;
	
	@JoinColumn (name = "id_disciplina", referencedColumnName = "id")
	@ManyToOne()
	private Disciplina disciplina;
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}
