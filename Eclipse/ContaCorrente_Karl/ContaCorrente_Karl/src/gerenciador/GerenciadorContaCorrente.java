package gerenciador;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import pessoa.Pessoa;
import console.Console;
import conta.ContaCorrente;
import conta.Extrato;
import conta.Operacoes;

public class GerenciadorContaCorrente 
{
	private Console console;
	private final int ULTRAPASSA_LIMITE = 1;
	
	public GerenciadorContaCorrente()
	{
		console = new Console();
	}
	
	public boolean realizarSaque (Pessoa pessoa, ContaCorrente conta, BigDecimal saque)
	{
		BigDecimal novoSaldo = conta.getSaldo();
		novoSaldo = novoSaldo.subtract(saque);
		BigDecimal limite = conta.getLimite();
		int permicao = limite.compareTo(novoSaldo);
		
		if (permicao == ULTRAPASSA_LIMITE)
		{
			console.printMessage("SAQUE NAO PERMITIDO");
			return false;
		}
		else
		{
			conta.setSaldo(novoSaldo);
			pessoa.setConta(conta);
			conta.setExtrato(cadastrarSaque(conta, saque));
			console.printMessage("SAQUE REALIZADO COM SUCESSO");
			return true;
		}
	}
	
	public void realizarDeposito (Pessoa pessoa, ContaCorrente conta, BigDecimal deposito)
	{
		BigDecimal novoSaldo = conta.getSaldo();
		novoSaldo = novoSaldo.add(deposito);
		conta.setSaldo(novoSaldo);
		conta.setExtrato(cadastrarDeposito(conta, deposito));
		pessoa.setConta(conta);
		console.printMessage("DEPOSITO REALIZADO COM SUCESSO");
	}
	
	public List<Extrato> cadastrarSaque(ContaCorrente conta, BigDecimal saque)
	{
		List<Extrato> extrato = conta.getExtrato();
		Extrato novoExtrato = new Extrato();
		
		Date date = console.readDate("Data da operacao:");
		novoExtrato.setDate(date);
		novoExtrato.setDescricao(Operacoes.SAQUE);
		novoExtrato.setValor(saque);
		extrato.add(novoExtrato);
		
		return extrato;
	}
	
	public List<Extrato> retornarExtrato (ContaCorrente conta)
	{
		List<Extrato> operacoes = conta.getExtrato();
		return operacoes;
	}
	
	public List<Extrato> cadastrarDeposito(ContaCorrente conta, BigDecimal deposito)
	{
		List<Extrato> extrato = conta.getExtrato();
		Extrato novoExtrato = new Extrato();
		
		Date date = console.readDate("Data da operacao:");
		novoExtrato.setDate(date);
		novoExtrato.setDescricao(Operacoes.DEPOSITO);
		novoExtrato.setValor(deposito);
		extrato.add(novoExtrato);
		
		return extrato;
	}
}
