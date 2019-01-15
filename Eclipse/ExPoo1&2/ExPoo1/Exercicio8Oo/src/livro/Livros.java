package livro;

public class Livros
{
	private String nome; 
	private String editora;
	private String autor; 
	private int edicao; 
	private String isbn; 
	private int qtdExemplares; 
	private String resumo; 
	private int ano;

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEditora()
	{
		return editora;
	}

	public void setEditora(String editora)
	{
		this.editora = editora;
	}

	public String getAutor() 
	{
		return autor;
	}

	public void setAutor(String autor)
	{
		this.autor = autor;
	}

	public int getEdicao() 
	{
		return edicao;
	}

	public void setEdicao(int edicao)
	{
		this.edicao = edicao;
	}

	public String getIsbn() 
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public int getQtdExemplares()
	{
		return qtdExemplares;
	}

	public void setQtdExemplares(int qtdExemplares)
	{
		this.qtdExemplares = qtdExemplares;
	}

	public String getResumo()
	{
		return resumo;
	}

	public void setResumo(String resumo) 
	{
		this.resumo = resumo;
	}

	public int getAno() 
	{
		return ano;
	}

	public void setAno(int ano)
	{
		this.ano = ano;
	}
}