package comanda;

import java.util.List;

import produto.Produto;

public class Comanda
{
	private int numero;
	private List <Produto> produtoLista;
	
	public int getNumero() 
	{
		return numero;
	}
	
	public void setNumero(int numero) 
	{
		this.numero = numero;
	}
	
	public List <Produto> getProdutoLista()
	{
		return produtoLista;
	}

	public void setProdutoLista(List <Produto> produtoLista)
	{
		this.produtoLista = produtoLista;
	}
	
	public void adcionarProdutoComanda (List <Produto> produtoLista, 
			Produto produto)
	{
		
	}
	
	public void precoTotal (List <Produto> produto)
	{
		
	}
}