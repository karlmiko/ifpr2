package gerenciador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pessoa.Pessoa;

public class GerenciadorPessoa 
{
	private int ultimoId;
	private HashMap <Integer,Pessoa> pessoas;
	
	public GerenciadorPessoa()
	{
		ultimoId = 0;
		pessoas = new HashMap <Integer, Pessoa>();
	}
	
	public void cadastrarPessoa(Pessoa pessoa)
	{	
		pessoa.setId(++ultimoId);
		pessoas.put(pessoa.getId(), pessoa); 
	}
	
	public List<Pessoa> listaPessoas()
	{
		return new ArrayList <Pessoa>(pessoas.values());
	}
	
	public void excluirPessoa(int id)
	{	
		boolean concluido = false;
		
		for (Pessoa pessoa : pessoas.values()) 
		{
			if (pessoa.getId() == id)
			{
				pessoas.remove(id);
				concluido = true;
				System.out.println("PESSOA EXCLUIDA COM SUCESSO");
				break;
			}
		}
		
		if (concluido == false)
		{
			System.out.println("ID INEXISTENTE");
		}
	}
}
