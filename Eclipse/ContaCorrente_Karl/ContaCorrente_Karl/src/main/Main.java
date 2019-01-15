package main;

import gerenciador.GerenciadorContaCorrente;
import gerenciador.GerenciadorPessoa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pessoa.Fisica;
import pessoa.Juridica;
import pessoa.Pessoa;
import pessoa.Sexo;
import pessoa.Usuario;
import pessoa.endereco.Endereco;
import console.Console;
import conta.ContaCorrente;
import conta.Extrato;
import conta.Operacoes;

public class Main 
{	
	private final int GERENCIAR_PESSOA = 1;
	private final int GERENCIAR_CONTA = 2;
	private final int CADASTRAR_PESSOA = 1;
	private final int ALTERAR_PESSOA = 2;
	private final int LISTAR_PESSOA = 3;
	private final int EXCLUIR_PESSOA = 4;
	private final int SAIR = 3;
	private final int PESSOA_FISICA = 1;
	private final int PESSOA_JURIDICA = 2;
	private final int USUARIO = 3;
	private final int NORMAL = 1;
	private final int SAQUE = 1;
	private final int DEPOSITO = 2;
	private final int TRANSFERENCIA = 3;
	private final int CONSULTAR_EXTRATO = 4;
	private final int MASCULINO = 1;
	private final int FEMININO = 2;
	
	private int opcao;
	
	private Console console;
	private GerenciadorPessoa gerenciarPessoa;
	private GerenciadorContaCorrente gerenciarConta;
	private ArrayList <Pessoa> pessoas;
	public static void main (String[] args)
	{
		new Main().executar();
	}
	
	private void executar()
	{
		console = new Console();
		gerenciarPessoa = new GerenciadorPessoa();
		gerenciarConta = new GerenciadorContaCorrente();
		
		while (true)
		{
			System.out.println("MENU:");
			System.out.println("1 - Gerenciar pessoa");
			System.out.println("2 - Gerenciar conta");
			System.out.println("3 - Sair");
			opcao = console.readInt("OPCAO:");
			
			if (opcao == GERENCIAR_PESSOA)
			{
				gerenciarPessoa();
			}
			else if (opcao == GERENCIAR_CONTA)
			{
				menuConta();
			}
			else if (opcao == SAIR)
			{
				break;
			}
		}
	}
	
	private void gerenciarPessoa()
	{	
		console.printMessage("GERENCIADOR DE PESSOAS:");
		console.printMessage("1 - Cadastrar pessoa");
		console.printMessage("2 - Alterar pessoa");
		console.printMessage("3 - Listar pessoas");
		console.printMessage("4 - Excluir pessoa");
		opcao = console.readInt("OPCAO:");
		
		if (opcao == CADASTRAR_PESSOA)
		{
			cadastrarPessoa();
		}
		else if (opcao == ALTERAR_PESSOA)
		{
			alterarPessoa();
		}
		else if (opcao == LISTAR_PESSOA)
		{
			listarPessoa();
		}
		else if (opcao == EXCLUIR_PESSOA)
		{
			excluirPessoa();
		}
		else
		{
			return;
		}
	}
	
	public void alterarPessoa()
	{
		List<Pessoa> pessoas = gerenciarPessoa.listaPessoas();
		int id = console.readInt("ID:");
		
		boolean concluido = false;
		
		for (Pessoa pessoa : pessoas) 
		{
			if (pessoa.getId() == id)
			{
				String nome = console.readLine("Nome:");
				pessoa.setNome(nome);
				int telefone = console.readInt("Telefone:");
				pessoa.setTelefone(telefone);
				Endereco endereco = new Endereco();
				String bairro = console.readLine("Bairro:");
				endereco.setBairro(bairro);
				int cep = console.readInt("CEP:");
				endereco.setCep(cep);
				String cidade = console.readLine("Cidade:");
				endereco.setCidade(cidade);
				String complemento = console.readLine("Complemento:");
				endereco.setComplemento(complemento);
				String estado = console.readLine("Estado:");
				endereco.setEstado(estado);
				String logradouro = console.readLine("Logradouro:");
				endereco.setLogradouro(logradouro);
				int numero = console.readInt("Numero:");
				endereco.setNumero(numero);
				pessoa.setEndereco(endereco);
				
				console.printMessage("PESSOA ALTERADA COM SUCESSO");
				concluido = true;
				break;
			}
		}
		if (concluido == false)
		{
			console.printMessage("ID NAO ENCONTRADO");
		}
	}
	
	public ContaCorrente cadastrarConta()
	{
		List<Extrato> extrato = new ArrayList<Extrato>();
		
		int tipoConta = console.readInt("Tipo da conta corrente - Normal(1) Especial(2):");
		
		if (tipoConta == NORMAL)
		{
			ContaCorrente conta = new ContaCorrente();
			
			String agencia = console.readString("Agencia:");
			conta.setAgencia(agencia);
			String numeroConta = console.readLine("Numero da conta:");
			conta.setNumero(numeroConta);
			BigDecimal saldo = BigDecimal.valueOf(console.readDouble("Saldo da conta em reais:"));
			conta.setSaldo(saldo);
			BigDecimal zero = BigDecimal.valueOf(0);
			conta.setLimite(zero);
			conta.setExtrato(extrato);
			
			return conta;
		}
		else
		{
			ContaCorrente conta = new ContaCorrente();
			
			String agencia = console.readString("Agencia:");
			conta.setAgencia(agencia);
			String numeroConta = console.readLine("Numero da conta:");
			conta.setNumero(numeroConta);
			BigDecimal saldo = BigDecimal.valueOf(console.readDouble("Saldo da conta em reais:"));
			conta.setSaldo(saldo);
			BigDecimal limite = BigDecimal.valueOf(console.readDouble("Limite da conta em reais (valor negativo):"));
			conta.setLimite(limite);
			conta.setExtrato(extrato);
			
			return conta;
		}
	}
	
	public void excluirPessoa()
	{
		console.printMessage("EXCLUIR PESSOA POR ID");
		int id = console.readInt("ID:");
		gerenciarPessoa.excluirPessoa(id);
	}
	
	
	public void listarPessoa()
	{
		pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(gerenciarPessoa.listaPessoas());	
		console.printMessage("LISTA DE PESSOAS:");
		
		for (Pessoa pessoa : pessoas) 
		{
			ContaCorrente conta = pessoa.getConta();
			console.printMessage(pessoa.getId() + "-" + pessoa.getNome() + " saldo - " + conta.getSaldo());
		}
	}
	
	private void cadastrarPessoa()
	{	
		console.printMessage("CADASTRO DE PESSOA:");
		console.printMessage("1 - Cadastrar pessoa f��sica");
		console.printMessage("2 - Cadastrar pessoa jur��dica");
		console.printMessage("3 - Cadastrar Usuario");
		opcao = console.readInt("OPCAO:");
		
		if (opcao == PESSOA_FISICA)
		{			
			Fisica pessoaFisica = new Fisica();
			
			String nome = console.readLine("Nome:");
			pessoaFisica.setNome(nome);
			String cpf = console.readLine("CPF:");
			pessoaFisica.setCpf(cpf);
			Date dataNascimento = console.readDate("Data de nascimento (dd/mm/aaaa):");
			pessoaFisica.setDataNascimento(dataNascimento);
			int rg = console.readInt("RG:");
			pessoaFisica.setRg(rg);
			int sexo = console.readInt("Sexo - Masculino(1) Feminino(2):");
			if (sexo == MASCULINO)
			{
				pessoaFisica.setSexo(Sexo.MASCULINO);
			}
			else if (sexo == FEMININO)
			{
				pessoaFisica.setSexo(Sexo.FEMININO);
			}
			int telefone = console.readInt("Telefone:");
			pessoaFisica.setTelefone(telefone);
			Endereco endereco = new Endereco();
			String bairro = console.readLine("Bairro:");
			endereco.setBairro(bairro);
			int cep = console.readInt("CEP:");
			endereco.setCep(cep);
			String cidade = console.readLine("Cidade:");
			endereco.setCidade(cidade);
			String complemento = console.readLine("Complemento:");
			endereco.setComplemento(complemento);
			String estado = console.readLine("Estado:");
			endereco.setEstado(estado);
			String logradouro = console.readLine("Logradouro:");
			endereco.setLogradouro(logradouro);
			int numero = console.readInt("Numero:");
			endereco.setNumero(numero);
			pessoaFisica.setEndereco(endereco);
			
			pessoaFisica.setConta(cadastrarConta());
			
			gerenciarPessoa.cadastrarPessoa(pessoaFisica);
			
			console.printMessage("PESSOA FISICA SALVA COM SUCESSO!");
		}
		if (opcao == PESSOA_JURIDICA)
		{
			Juridica pessoaJuridica = new Juridica();
			
			String nome = console.readLine("Nome:");
			pessoaJuridica.setNome(nome);
			int telefone = console.readInt("Telefone:");
			pessoaJuridica.setTelefone(telefone);
			String cnpj = console.readString("CNPJ:");
			pessoaJuridica.setCnpj(cnpj);
			int inscricaoEstadual = console.readInt("Inscricao estadual:");
			pessoaJuridica.setInscricaoEstadual(inscricaoEstadual);
			Endereco endereco = new Endereco();
			String bairro = console.readLine("Bairro:");
			endereco.setBairro(bairro);
			int cep = console.readInt("CEP:");
			endereco.setCep(cep);
			String cidade = console.readLine("Cidade:");
			endereco.setCidade(cidade);
			String complemento = console.readLine("Complemento:");
			endereco.setComplemento(complemento);
			String estado = console.readLine("Estado:");
			endereco.setEstado(estado);
			String logradouro = console.readLine("Logradouro:");
			endereco.setLogradouro(logradouro);
			int numero = console.readInt("Numero:");
			endereco.setNumero(numero);
			pessoaJuridica.setEndereco(endereco);
			
			pessoaJuridica.setConta(cadastrarConta());

			gerenciarPessoa.cadastrarPessoa(pessoaJuridica);
			
			console.printMessage("PESSOA JURIDICA SALVA COM SUCESSO!");
		}
		if (opcao == USUARIO)
		{
			Usuario usuario = new Usuario();
			
			String nome = console.readLine("Nome:");
			usuario.setNome(nome);
			int RG = console.readInt("RG:");
			usuario.setRg(RG);
			String CPF = console.readLine("CPF:");
			usuario.setCpf(CPF);
			String login = console.readLine("Login:");
			usuario.setLogin(login);
			String senha = console.readLine("Senha:");
			usuario.setSenha(senha);
			
			gerenciarPessoa.cadastrarPessoa(usuario);
			
			console.printMessage("USUARIO SALVO COM SUCESSO!");
		}
	}
	
	public void menuConta()
	{	
		pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(gerenciarPessoa.listaPessoas());
		
		int idPessoa = console.readInt("ID da pessoa: ");
		
		boolean concluido = false;
		
		for (Pessoa pessoa : pessoas) 
		{
			if (pessoa.getId() == idPessoa)
			{
				gerenciarConta(pessoa);
				concluido = true;
				break;
			}
		}
		
		if (concluido == false)
		{
			System.out.println("ID INEXISTENTE");
		}
	}
	
	public void gerenciarConta (Pessoa pessoa)
	{	
		pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(gerenciarPessoa.listaPessoas());
		
		console.printMessage("OPERACOES:");
		console.printMessage("1 - Realizar saque");
		console.printMessage("2 - Realizar deposito");
		console.printMessage("3 - Realizar transferencia");
		console.printMessage("4 - Consultar extrato");
		opcao = console.readInt("OPCAO:");
		
		if (opcao == SAQUE)
		{
			ContaCorrente conta = pessoa.getConta();
			
			BigDecimal saque = BigDecimal.valueOf(console.readDouble("Valor a ser sacado:"));		
			gerenciarConta.realizarSaque(pessoa, conta, saque);
		}
		if (opcao == DEPOSITO)
		{	
			ContaCorrente conta = pessoa.getConta();
			
			BigDecimal deposito = BigDecimal.valueOf(console.readDouble("Valor a ser depositado:"));
			gerenciarConta.realizarDeposito(pessoa, conta, deposito);
		}
		if (opcao == TRANSFERENCIA)
		{
			ContaCorrente conta = pessoa.getConta(); 
			
			int idRecebedor = console.readInt("ID da pessoa que recebera o valor: ");
			BigDecimal transferencia = BigDecimal.valueOf(console.readDouble("Valor a ser transferido:"));
			
			boolean concluido = false;
			
			for (Pessoa recebedor: pessoas) 
			{
				if (recebedor.getId() == idRecebedor)
				{
					boolean permitirTransferencia = gerenciarConta.realizarSaque(pessoa, conta, transferencia);
					
					if (permitirTransferencia == true)
					{
						ContaCorrente contaRecebedor = recebedor.getConta();
						gerenciarConta.realizarDeposito(recebedor, contaRecebedor, transferencia);
					}
					concluido = true;
				}
			}
			
			if (concluido == false)
			{
				System.out.println("ID INEXISTENTE");
			}
		}
		if (opcao == CONSULTAR_EXTRATO)
		{
			ContaCorrente conta = pessoa.getConta();	
			List<Extrato> extratos = gerenciarConta.retornarExtrato(conta);
			console.printMessage("EXTRATO BANCARIO");
			
			for (Extrato extrato : extratos) 
			{
				Date date = extrato.getDate();
				console.printDate(date);
				if (extrato.getDescricao() == Operacoes.SAQUE)
				{
					console.printMessage("SAQUE, valor:" + extrato.getValor());
				}
				if (extrato.getDescricao() == Operacoes.DEPOSITO)
				{
					console.printMessage("DEPOSITO, valor:" + extrato.getValor());
				}
			}
		}
	}
}