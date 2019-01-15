package emprestimoLivro;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import livro.Livros;
import aluno.Alunos;

public class Emprestimo
{	
	private Date diasAtraso;
	private BigDecimal valorDiaAtraso;

	public Date getDiasAtraso() {
		return diasAtraso;
	}

	public void setDiasAtraso(Date diasAtraso) {
		this.diasAtraso = diasAtraso;
	}
	
	public BigDecimal getValorDiaAtraso() {
		return valorDiaAtraso;
	}

	public void setValorDiaAtraso(BigDecimal valorDiaAtraso) {
		this.valorDiaAtraso = valorDiaAtraso;
	}
	
	public void emprestarLivroAlunos (Alunos aluno, 
			List <Livros> livros, Date diaInicio, Date diaFim)
	{
		
	}
	
	public void calculaMulta (Alunos aluno, Date diasAtraso, BigDecimal valorDiaAtraso)
	{
		
	}
}
