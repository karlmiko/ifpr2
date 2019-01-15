package veiculo;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GerenciarVeiculos 
{

	HashMap <Integer, Veiculo> listaDeVeiculos = new HashMap <Integer, Veiculo>();
	int ultimoId = 0;
	
	public void salvar(Veiculo carro) 
	{
		ultimoId++;
		carro.setId(ultimoId);
		listaDeVeiculos.put(carro.getId(), carro);
	}

	public List <Veiculo> listar() 
	{
		return new ArrayList <Veiculo>(listaDeVeiculos.values());	
	}

	public Veiculo procurarPorNome(String string) throws Exception 
	{
		List <Veiculo> listaVeiculos = listar();
		
		for (Veiculo veiculo : listaVeiculos) 
		{
			if (veiculo.getNome() == string)
			{
				return veiculo;
			}
		}
		throw new Exception("Ve�culo n�o encontrado");
		
	}

	public void alterar(Veiculo carroSalvo) 
	{
		listaDeVeiculos.put(carroSalvo.getId(), carroSalvo);
	}

	public void remover(int id) throws Exception
	{			
		if (!listaDeVeiculos.containsKey(id))
		{
			throw new Exception("Ve�culo n�o encontrado");
		}
		
		listaDeVeiculos.remove(id);
	}

	public void remover(String string) throws Exception
	{
		if (!listaDeVeiculos.containsKey(string))
		{
			throw new Exception ("Ve�culo n�o encontrado");
		}
		
		listaDeVeiculos.remove(string);
	}

	public Veiculo procurarPorId(int i) throws Exception
	{
		List <Veiculo> listaVeiculos = listar();
		
		for (Veiculo veiculo : listaVeiculos) 
		{
			if (veiculo.getId() == i)
			{
				return veiculo;
			}
		}
		throw new Exception("Ve�culo n�o encontrado");
	}

}
