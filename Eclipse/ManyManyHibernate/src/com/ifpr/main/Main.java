package com.ifpr.main;

import java.util.List;

import com.ifpr.cliente.Cliente;
import com.ifpr.console.Console;
import com.ifpr.entityManager.EntitySingleton;
import com.ifpr.funcionario.Funcionario;
import com.ifpr.funcionarioProjeto.FuncionarioProjeto;
import com.ifpr.funcionarioProjeto.dao.FuncionarioProjetoDao;
import com.ifpr.funcionarioProjeto.dao.FuncionarioProjetoDaoImpl;
import com.ifpr.pessoa.Pessoa;
import com.ifpr.pessoa.dao.PessoaDao;
import com.ifpr.pessoa.dao.PessoaDaoImpl;
import com.ifpr.projeto.Projeto;
import com.ifpr.projeto.dao.ProjetoDao;
import com.ifpr.projeto.dao.ProjetoDaoImpl;

public class Main 
{	
	private final int CADASTRAR = 1;
	private final int LISTAR = 2;
	private final int ATUALIZAR = 3;
	private final int REMOVER = 4;
	private final int VOLTAR = 5;
	private final int GER_PESSOA = 1;
	private final int GER_PROJETO = 2;
	private final int CADASTRAR_FUNCIONARIO_PROJETO = 3;
	private final int CLIENTE = 1;
	private final int FUNCIONARIO = 2;
	
	private ProjetoDao gerProjeto = new ProjetoDaoImpl(Projeto.class);
	private FuncionarioProjetoDao gerFuncionarioProjeto =
			new FuncionarioProjetoDaoImpl(FuncionarioProjeto.class);
	private PessoaDao gerPessoa = new PessoaDaoImpl(Pessoa.class);
	private Console console =  new Console();
	
	public static void main(String[] args) 
	{
		new Main().executar();	
	}
	
	public void executar()
	{	
		int opcao = 0;
		
		while(opcao != VOLTAR)
		{
			showMenu();
			opcao = console.readInt("Opcao: ");
			
			if (opcao == GER_PESSOA)
			{
				opcoesPessoa(opcao);
			}
			if (opcao == GER_PROJETO)
			{
				opcoesProjeto(opcao);
			}	
			if (opcao == CADASTRAR_FUNCIONARIO_PROJETO)
			{
				cadastrarFuncionarioProjeto();
			}
			if (opcao == VOLTAR)
			{
				EntitySingleton.closeEntityManager();
			}
		}	
	}
	
	private void showMenuPessoa() 
	{
		System.out.println("1: Cadastrar pessoa");
		System.out.println("2: Listar pessoas");
		System.out.println("3: Atualizar pessoa");
		System.out.println("4: Remover pessoa");
		System.out.println("5: Voltar");
	}

	public void cadastrarPessoa()
	{	
		int opcao = definirPessoa("Deseja cadastrar um cliente(1) ou um funcionário(2)? ");
		
		Pessoa pessoa = null;
		
		if (opcao == CLIENTE)
		{
			Cliente cliente = new Cliente();
			cliente.setNome(console.readLine("Nome do cliente: "));
			cliente.setInscricaoEst(console.readInt("Inscricao estadual: "));
			cliente.setCnpj(console.readInt("CNPJ do cliente: "));
			pessoa = cliente;
		}
		if (opcao == FUNCIONARIO)
		{
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(console.readLine("Nome do funcionario: "));
			funcionario.setRg(console.readInt("RG do funcionario: "));
			funcionario.setCpf(console.readInt("CPF do funcionario: "));
			pessoa = funcionario;
		}
		
		gerPessoa.save(pessoa);
	}

	public int definirPessoa(String mensagem)
	{	
		int opcao = 0;
		do {
			opcao = console.readInt(mensagem);
		} while (opcao != CLIENTE && opcao != FUNCIONARIO);
		
		return opcao;
	}

	public void listarPessoas()
	{
		int qtd = console.readInt("Quantidade: ");
		
		List<Pessoa> listaPessoas = gerPessoa.list(qtd);
		
		for (Pessoa pessoa : listaPessoas) 
		{
			System.out.println("Id: " + pessoa.getId());
			System.out.println("Nome: " + pessoa.getNome());
			pessoa.mostrarAtributos();
		}
	}

	public void deletarPessoa()
	{
		int id = console.readInt("ID da pessoa a ser removida: ");
		Pessoa pessoa = gerPessoa.findById(id);
		gerPessoa.remove(pessoa);	
	}

	public void atualizarPessoa()
	{
		int opcao = definirPessoa("Deseja atualizar um cliente(1) ou um funcionário(2)? ");
		int id = console.readInt("ID da pessoa a ser removida: ");
		
		Pessoa pessoa = null;
			
		if (opcao == CLIENTE)
		{	
			Cliente cliente = (Cliente)gerPessoa.findById(id);
			cliente.setNome(console.readLine("Novo nome do cliente: "));
			cliente.setInscricaoEst(console.readInt("Nova inscricao estadual do cliente: "));
			cliente.setCnpj(console.readInt("Novo CNPJ do cliente: "));
			pessoa = cliente;
		}
		if (opcao == FUNCIONARIO)
		{
			Funcionario funcionario = (Funcionario)gerPessoa.findById(id);
			funcionario.setNome(console.readLine("Novo nome do funcionario: "));
			funcionario.setRg(console.readInt("Novo RG do funcionario: "));
			funcionario.setCpf(console.readInt("Novo CPF do funcionario: "));				
			pessoa = funcionario;
		}
			
		gerPessoa.update(pessoa);
	}

	public void opcoesPessoa(int opcao)
	{
		while (opcao != VOLTAR)
		{	
			showMenuPessoa();
			opcao = console.readInt("Opcao: ");
			
			if (opcao == CADASTRAR)
			{
				cadastrarPessoa();
			}
			if (opcao == LISTAR)
			{
				listarPessoas();
			}
			if (opcao == ATUALIZAR)
			{
				atualizarPessoa();
			}
			if (opcao == REMOVER)
			{
				deletarPessoa();
			}
		}
	}

	private void cadastrarFuncionarioProjeto() 
	{
		FuncionarioProjeto relacao = new FuncionarioProjeto();
		Funcionario funcionario = (Funcionario) gerPessoa.findById(
				console.readInt("Id do funcionario: "));
		Projeto projeto = gerProjeto.findById(console.readInt("Id do projeto: "));	
		relacao.setFuncionario(funcionario);
		relacao.setProjeto(projeto);	
		gerFuncionarioProjeto.save(relacao);	
	}

	private void opcoesProjeto(int opcao) 
	{
		while(opcao != VOLTAR)
		{	
			showMenuProjeto();
			opcao = console.readInt("Opcao: ");
			
			if (opcao == CADASTRAR)
			{
				criarProjeto();
			}
			if (opcao == LISTAR)
			{
				listarProjetos();
			}
			if (opcao == ATUALIZAR)
			{
				atualizarProjeto();
			}
			if (opcao == REMOVER)
			{
				deletarProjeto();
			}
		}
	}

	private void deletarProjeto() 
	{
		int id = console.readInt("ID do projeto a ser removido: ");
		Projeto projeto = gerProjeto.findById(id);
		gerProjeto.remove(projeto);
	}

	private void atualizarProjeto() 
	{
		int id = console.readInt("ID do projeto a ser atualizado: ");
		Projeto projeto = gerProjeto.findById(id);
		projeto.setNome(console.readLine("Novo nome do projeto: "));
		projeto.setDataInicio(console.readDate("Nova data de inicio: "));
		projeto.setDataFim(console.readDate("Nova data de fim: "));
		gerProjeto.update(projeto);
	}

	private void listarProjetos()
	{
		int qtd = console.readInt("Quantidade: ");
		
		List<Projeto> listaProjetos = gerProjeto.list(qtd);
		
		for (Projeto projeto : listaProjetos) 
		{
			System.out.println("ID: " + projeto.getId());
			System.out.println("Nome: " + projeto.getNome());
			System.out.println("Data de inicio: " + projeto.getDataInicio());
			System.out.println("Data de fim: " + projeto.getDataFim());
			
			System.out.println("");
		}
	}

	private void criarProjeto()
	{
		Projeto projeto = new Projeto();
		projeto.setNome(console.readLine("Nome do novo projeto: "));
		projeto.setDataInicio(console.readDate("Data de inicio (dd/mm/aaaa): "));
		projeto.setDataFim(console.readDate("Data de fim (dd/mm/aaaa): "));
		gerProjeto.save(projeto);
	}

	public void showMenu()
	{
		System.out.println("1: Gerenciar pessoa");
		System.out.println("2: Gerenciar projeto");
		System.out.println("3: Relacionamento funcionario e projeto");
		System.out.println("5: Sair");
	}
	
	public void showMenuProjeto()
	{
		System.out.println("1: Cadastrar projeto");
		System.out.println("2: Listar projetos");
		System.out.println("3: Atualizar projeto");
		System.out.println("4: Remover projeto");
		System.out.println("5: Voltar");	
	}
}
