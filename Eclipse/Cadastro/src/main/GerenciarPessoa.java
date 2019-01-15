package main;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GerenciarPessoa {

	private int ultimoId;
	private HashMap <Integer, Pessoa> pessoas;
	
	public GerenciarPessoa() {
		ultimoId = 0;
		pessoas = new HashMap<Integer, Pessoa>();
	}
	
	public void inserir(Pessoa pessoa) throws Exception
	{
		if ( pessoa.getId() > 0 )
		{
			throw new Exception("Pessoa não pode ter ID");
		}
		pessoa.setId(++ultimoId);
		pessoas.put(ultimoId, pessoa);
	}
	
	public List<Pessoa> listar()
	{
		return new ArrayList<Pessoa>(pessoas.values());
	}
	
	public void delete (Pessoa pessoa) throws Exception
	{
		if ( !pessoas.containsKey(pessoa))
		{
			throw new Exception("Não existe a pessoa!");
		}
		
		pessoas.remove(pessoa);
	}
	
	public void update (Pessoa pessoa) throws Exception
	{
		if (pessoa.getId() == 0)
		{
			throw new Exception ("Pessoa deve possui id!");
		}
		
		pessoas.put(pessoa.getId(), pessoa);
	}
	
	/*public void deletePessoaInexistente (Pessoa pessoa) throws Exception
	{
		if ( !pessoas.containsKey(pessoa))
		{
			pessoas.remove(pessoa);
			throw new Exception("Não existe a pessoa!");
		}
		
	}*/
}
