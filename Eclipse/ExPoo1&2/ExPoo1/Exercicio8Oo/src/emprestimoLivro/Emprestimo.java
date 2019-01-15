package emprestimoLivro;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import professor.Professor;

import livro.Livros;

import aluno.Alunos;

public class Emprestimo
{
	private BigDecimal multaAluno;
	private BigDecimal multaProfessor;
	
	public BigDecimal getMultaAluno() {
		return multaAluno;
	}

	public void setMultaAluno(BigDecimal multaAluno) {
		this.multaAluno = multaAluno;
	}

	public BigDecimal getMultaProfessor() {
		return multaProfessor;
	}

	public void setMultaProfessor(BigDecimal multaProfessor) {
		this.multaProfessor = multaProfessor;
	}

	public void emprestimoAluno (Date dataInicio, Alunos aluno,
			List <Livros> livro,  Date dataFim)
	{
		
	}
	
	public void emprestimoProfessor (Date dataInicio, Professor professor,
			List <Livros> livro,  Date dataFim)
	{
		
	}
	
	public void multaAluno (Date dataFim, BigDecimal multaAluno)
	{
		
	}
	
	public void multaProfessor (Date dataFim, BigDecimal multaProfessor)
	{
		
	}
	
	
}
