package testeGerenciarVeiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import veiculo.GerenciarVeiculos;
import veiculo.Veiculo;

public class TestGerenciarVeiculos
{
	private GerenciarVeiculos gerenciarVeiculos;

	@Before
	public void setUp() throws Exception
	{
		gerenciarVeiculos = new GerenciarVeiculos();
	}

	@Test
	public void testCadastrarVeiculo()
	{
		Veiculo carro = criarCarro("Palio", "Fiat", "Fire", new BigDecimal(20.000));
		
		gerenciarVeiculos.salvar(carro);
		
		assertEquals(1, gerenciarVeiculos.listar().size());
		try
		{
			Veiculo carroSalvo = gerenciarVeiculos.procurarPorNome("Palio");
			assertTrue("O Id deveria ser maior que zero", carroSalvo.getId() > 0);
			assertEquals("Fiat", carroSalvo.getMarca());
			assertEquals("Fire", carroSalvo.getModelo());
			assertEquals(new BigDecimal(20.000), carroSalvo.getPreco());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("O carro deveria estar cadastrado");
		}
	}

	@Test
	public void testListarCarros()
	{
		Veiculo carroUm = criarCarro("Palio", "Fiat", "Fire", new BigDecimal(25.000));
		Veiculo carroDois = criarCarro("Uno", "Fiat", "Economy", new BigDecimal(20.000));
		
		gerenciarVeiculos.salvar(carroUm);
		gerenciarVeiculos.salvar(carroDois);
		
		assertEquals("Tamanho da lista deveria ser 2", 2, gerenciarVeiculos.listar().size());
	}

	@Test
	public void testAlterarCarro()
	{
		Veiculo carro = criarCarro("Palio", "Fiat", "Fire", new BigDecimal(20.000));
		
		gerenciarVeiculos.salvar(carro);
		
		try
		{
			Veiculo carroSalvo = gerenciarVeiculos.procurarPorNome("Palio");
			carroSalvo.setPreco(25d);
			gerenciarVeiculos.alterar(carroSalvo);
			
			Veiculo carroAlterado = gerenciarVeiculos.procurarPorNome("Palio");
			assertEquals("O pre�o deveria estar alterado", new BigDecimal(25.000), carroAlterado.getPreco());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("O carro deveria estar cadastrado");
		}
	}

	@Test
	public void testRemoverCarroPorId()
	{
		Veiculo carro = criarCarro("Palio", "Fiat", "Fire", new BigDecimal(20.000));
		
		gerenciarVeiculos.salvar(carro);
		
		try
		{
			Veiculo carroSalvo = gerenciarVeiculos.procurarPorNome("Palio");
			gerenciarVeiculos.remover(carroSalvo.getId());
			assertTrue("A lista deveria estar vazia", gerenciarVeiculos.listar().isEmpty());
		}
		catch (Exception e)
		{
			fail("O carro deveria estar cadastrado");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testRemoverCarroPorNome()
	{
		Veiculo carro = criarCarro("Palio", "Fiat", "Fire", new BigDecimal(20.000));
		
		gerenciarVeiculos.salvar(carro);
		
		try
		{
			gerenciarVeiculos.remover("Palio");
			assertTrue("A lista deveria estar vazia", gerenciarVeiculos.listar().isEmpty());
		}
		catch (Exception e)
		{
			fail("O carro deveria estar cadastrado");
			e.printStackTrace();
		}
		
	}
	
	private Veiculo criarCarro(String nome, String marca, String modelo, BigDecimal preco)
	{
		Veiculo carro = new Veiculo();
		carro.setNome(nome);
		carro.setMarca(marca);
		carro.setModelo(modelo);
		carro.setPreco(preco.doubleValue());
		return carro;
	}
	
	@Test
	public void testProcurarCarroIdInexistente()
	{
		try
		{
			gerenciarVeiculos.procurarPorId(10);
			fail("N�o deveria ter encontrado o carro com id 10");
		}
		catch (Exception e)
		{
			assertEquals("Ve�culo n�o encontrado", e.getMessage());
		}
	}
	
	@Test
	public void testProcurarCarroNomeInexistente()
	{
		try
		{
			gerenciarVeiculos.procurarPorNome("jahsdkjfjha");
			fail("N�o deveria ter encontrado o carro com id ajkdfj");
		}
		catch (Exception e)
		{
			assertEquals("Ve�culo n�o encontrado", e.getMessage());
		}
	}
	
	@Test
	public void testRemoverCarroInexistente()
	{
		try
		{
			gerenciarVeiculos.remover("jhsafj");
			fail("N�o deveria ter removido o ve�culo com nome 10");
		}
		catch (Exception e)
		{
			assertEquals("Ve�culo n�o encontrado", e.getMessage());
		}
	}

}

