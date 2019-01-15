package filmes.locacao;

import java.util.Date;
import java.util.List;

import cliente.Cliente;

import filmes.Filmes;

public class Locacao
{
	private String codigo;
	private Date data;
	
	public void locacao (List <Filmes> filmes, Cliente cliente)
	{
		
	}
	
	public void calculaPreco (List <Filmes> filmes,
			TabelaPreco tabela)
	{
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}