package produto;

public class Produto
{
	private String nome;
	private int quantidade;
	private float precoUnidade;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public int getQuantidade() 
	{
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) 
	{
		this.quantidade = quantidade;
	}
	
	public float getPrecoUnidade() 
	{
		return precoUnidade;
	}
	
	public void setPrecoUnidade(float precoUnidade) 
	{
		this.precoUnidade = precoUnidade;
	}
}