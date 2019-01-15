package ifpr.main;

import ifpr.console.Console;
import ifpr.exame.Exame;
import ifpr.exame.dao.ExameDao;
import ifpr.exame.dao.ExameDaoImpl;
import ifpr.pacienteExame.dao.PacienteExameDao;
import ifpr.pacienteExame.dao.PacienteExameDaoImpl;
import ifpr.pacienteExame.PacienteExame;
import ifpr.pessoa.Pessoa;
import ifpr.pessoa.dao.PessoaDao;
import ifpr.pessoa.dao.PessoaDaoImpl;
import ifpr.pessoa.medico.Medico;
import ifpr.pessoa.paciente.Paciente;

public class Main 
{
	private static final int CADASTRAR = 1;
	private static final int REMOVER = 2;
	private static final int ATUALIZAR = 3;
	private static final int LISTAR = 4;
	private static final int VOLTAR = 5;
	private final int GERENCIAR_PACIENTE = 1;
	private final int GERENCIAR_EXAME = 2;
	private final int RELACIONAR_PACIENTE_EXAME = 3;
	private final int ENCERRAR = 4;
	
	private PessoaDao gerPessoa = new PessoaDaoImpl(Pessoa.class);
	private ExameDao gerExame = new ExameDaoImpl(Exame.class);
	private PacienteExameDao gerRelacao = new PacienteExameDaoImpl(PacienteExame.class);
	private Console console = new Console();
	
	public static void main (String [] args)
	{
		new Main().executar();
	}

	private void executar() 
	{
		/*int opcao = 0;
		
		do
		{
			mostrarMenu();
			opcao = console.readInt("Opcao: ");
			
			if (opcao == GERENCIAR_PACIENTE)
			{
				gerenciarPaciente();
			}
			else if (opcao == GERENCIAR_EXAME)
			{
				gerenciarExame();
			}
			else if (opcao == RELACIONAR_PACIENTE_EXAME)
			{
				relacionarPacienteExame();
			}
			
		} while (opcao != ENCERRAR);*/
		
		Paciente paciente = new Paciente();
		paciente.setNome("kibe");
		paciente.setCpf(9);
		paciente.setRg(9);
		gerPessoa.save((Paciente)paciente);
		
		Exame exame = new Exame();
		exame.setNome("Exame de fezes");
		gerExame.save(exame);
		
		PacienteExame relacao = new PacienteExame();
		relacao.setExame(exame);
		relacao.setPaciente(paciente);
		gerRelacao.save(relacao);
		
		/*Medico medico = new Medico();
		medico.setNome("Karl");
		medico.setEspecialidade("Otorrino");
		gerPessoa.save((Medico) medico);*/
	}

	private void mostrarMenu() 
	{
		System.out.println("1 - Gerenciar paciente");
		System.out.println("2 - Gerenciar exame");
		System.out.println("3 - Relacionar paciente e exame");
		System.out.println("4 - Sair");
	}

	private void gerenciarPaciente() 
	{
		int opcao = 0;
		
		do
		{
			mostrarMenuGerenciar("paciente(s)");
			opcao = console.readInt("Opcao: ");
			
			if (opcao == CADASTRAR)
			{
				cadastrarPaciente();
			}
			else if (opcao == REMOVER)
			{
				removerPaciente();
			}
			else if (opcao == ATUALIZAR)
			{
				atualizarPaciente();
			}
			else if (opcao == LISTAR)
			{
				listarPaciente();
			}
			
		} while (opcao != VOLTAR);
		
	}
	
	private void listarPaciente() {
		// TODO Auto-generated method stub
		
	}

	private void atualizarPaciente() {
		// TODO Auto-generated method stub
		
	}

	private void removerPaciente() {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarPaciente() {
		// TODO Auto-generated method stub
		
	}

	private void gerenciarExame() 
	{
		int opcao = 0;
		
		do
		{
			mostrarMenuGerenciar("exame(s)");
			opcao = console.readInt("Opcao: ");
			
			if (opcao == CADASTRAR)
			{
				cadastrarExame();
			}
			else if (opcao == REMOVER)
			{
				removerExame();
			}
			else if (opcao == ATUALIZAR)
			{
				atualizarExame();
			}
			else if (opcao == LISTAR)
			{
				listarExame();
			}
			
		} while (opcao != VOLTAR);
	}

	private void listarExame() 
	{
		// TODO Auto-generated method stub	
	}

	private void atualizarExame() 
	{
		// TODO Auto-generated method stub	
	}

	private void removerExame() 
	{
		// TODO Auto-generated method stub	
	}

	private void cadastrarExame()
	{
		// TODO Auto-generated method stub	
	}
	
	private void relacionarPacienteExame() 
	{
		// TODO Auto-generated method stub		
	}
	
	private void mostrarMenuGerenciar(String tipoGerenciar) 
	{
		System.out.println("1 - Cadastrar " + tipoGerenciar);
		System.out.println("2 - Remover " + tipoGerenciar);
		System.out.println("3 - Atualizar " + tipoGerenciar);
		System.out.println("4 - Listar " + tipoGerenciar);
		System.out.println("5 - Voltar");
	}
}
