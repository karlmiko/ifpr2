package professor;

import java.util.List;

import turma.Turma;

import disciplina.Disciplina;

public class Professor {
	
	private String matricula;
	private String nome;
	private String rg;
	private List <Disciplina> disciplina;
	private List <Turma> turma;
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}

	public List <Turma> getTurma() {
		return turma;
	}

	public void setTurma(List <Turma> turma) {
		this.turma = turma;
	}

	public List <Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List <Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
}
