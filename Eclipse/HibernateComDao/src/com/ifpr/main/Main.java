package com.ifpr.main;

import java.util.ArrayList;
import java.util.List;

import com.ifpr.aluno.Aluno;
import com.ifpr.aluno.dao.AlunoDao;
import com.ifpr.aluno.dao.AlunoDaoImpl;
import com.ifpr.console.Console;
import com.ifpr.curso.Curso;
import com.ifpr.curso.dao.CursoDao;
import com.ifpr.curso.dao.CursoDaoImpl;
import com.ifpr.disciplina.Disciplina;
import com.ifpr.disciplina.dao.DisciplinaDao;
import com.ifpr.disciplina.dao.DisciplinaDaoImpl;
import com.ifpr.disciplinaAluno.DisciplinaAluno;
import com.ifpr.disciplinaAluno.dao.DisciplinaAlunoDaoImpl;
import com.ifpr.endereco.Endereco;
import com.ifpr.entityManager.EntitySingleton;
import com.ifpr.telefone.Telefone;

public class Main 
{	
	private final int CADASTRAR_ALUNO_CURSO = 5;
	private final int CADASTRAR = 1;
	private final int LISTAR = 2;
	private final int ATUALIZAR = 3;
	private final int REMOVER = 4;
	private final int VOLTAR = 6;
	private final int GER_ALUNO = 1;
	private final int GER_CURSO = 2;
	private final int GER_DISCIPLINA = 3;
	private final int CADASTRAR_ALUNO_DISCIPLINA = 4;
	
	private AlunoDao gerAluno = new AlunoDaoImpl(Aluno.class);
	private DisciplinaDao gerDisciplina = new DisciplinaDaoImpl(Disciplina.class);
	private DisciplinaAlunoDaoImpl gerDisciplinaAluno = 
			new DisciplinaAlunoDaoImpl(DisciplinaAluno.class);
	private CursoDao gerCurso = new CursoDaoImpl(Curso.class);
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
			
			if (opcao == GER_ALUNO)
			{
				opcoesAluno(opcao);
			}
			if (opcao == GER_CURSO)
			{
				opcoesCurso(opcao);
			}
			if (opcao == GER_DISCIPLINA)
			{
				opcoesDisciplina(opcao);
			}	
			if (opcao == CADASTRAR_ALUNO_DISCIPLINA)
			{
				cadastrarDisciplinaAluno();
			}
			if (opcao == CADASTRAR_ALUNO_CURSO)
			{
				cadastrarAlunoCurso();
			}
			if (opcao == VOLTAR)
			{
				EntitySingleton.closeEntityManager();
			}
		}	
	}
	
	public void showMenu()
	{
		System.out.println("1: Gerenciar aluno");
		System.out.println("2: Gerenciar curso");
		System.out.println("3: Gerenciar disciplina");
		System.out.println("4: Relacionamento aluno e disciplina");
		System.out.println("5: Relacionamento aluno e curso");
		System.out.println("6: Sair");
	}

	public void showMenuAluno()
	{
		System.out.println("1: Cadastrar Aluno");
		System.out.println("2: Listar Alunos");
		System.out.println("3: Atualizar Aluno");
		System.out.println("4: Remover Aluno");
		System.out.println("6: Voltar");	
	}

	public void opcoesAluno(int opcao)
	{
		while(opcao != VOLTAR)
		{	
			showMenuAluno();
			opcao = console.readInt("Opcao: ");
			
			if (opcao == CADASTRAR)
			{
				cadastrarAluno();
			}
			if (opcao == LISTAR)
			{
				listarAluno();
			}
			if (opcao == ATUALIZAR)
			{
				atualizarAluno();
			}
			if (opcao == REMOVER)
			{
				deletarAluno();
			}
		}
	}

	public void cadastrarAluno()
	{	
		Aluno aluno = new Aluno();
		aluno = lerInformacoes(aluno);
		int qtdQuantidades = console.readInt("Quantos telefones deseja cadastrar: ");
		aluno.setTelefones(lerTelefones(qtdQuantidades));
		gerAluno.save(aluno);
	}

	public Aluno lerInformacoes(Aluno aluno)
	{
		aluno.setNome(console.readString("Nome: "));
		aluno.setLogin(console.readString("Login: "));
		aluno.setSenha(console.readString("Senha: "));
		aluno.setDataNascimento(console.readDate("Data Nascimento: "));
		aluno.setMatricula(console.readString("Matricula: "));
		aluno.setEndereco(lerEndereco());
		
		return aluno;
	}

	public Endereco lerEndereco()
	{
		System.out.println(":::::Endereco:::::");
		Endereco endereco = new Endereco();
		endereco.setBairro(console.readString("Bairro: "));
		endereco.setCep(console.readString("CEP: "));
		endereco.setLogradouro(console.readString("Logradouro: "));
		return endereco;
	}

	private List<Telefone> lerTelefones(int qtdTelefones) 
	{
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		
		for (int i = 0; i < qtdTelefones; i++)
		{
			Telefone telefone = new Telefone();
			telefone.setDdd(console.readInt("DDD: "));
			telefone.setTelefone(console.readInt("Telefone: "));
			listaTelefones.add(telefone);
		}
		
		return listaTelefones;
	}

	public void listarAluno()
	{
		int qtd = console.readInt("Quantidade: ");
		
		List<Aluno> listarararararaAlunos = gerAluno.list(qtd);
		
		for (Aluno aluno : listarararararaAlunos) 
		{
			System.out.println("ID: " + aluno.getId());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Login: " + aluno.getLogin());
			System.out.println("Senha: " + aluno.getSenha());
			System.out.println("Data Nascimento: " + aluno.getDataNascimento());
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println(":::::Endereco:::::");
			System.out.println("Bairro: " + aluno.getEndereco().getBairro());
			System.out.println("CEP: " + aluno.getEndereco().getCep());
			System.out.println("Logradouro: " + aluno.getEndereco().getLogradouro());
			for (Telefone telefone : aluno.getTelefones()) 
			{
				System.out.println("Telefone: (" + telefone.getDdd()
						+ ") " + telefone.getTelefone());
			}
			
			System.out.println("");
		}
	}

	public void atualizarAluno()
	{
		int id = console.readInt("ID do aluno a ser atualizado: ");
		Aluno aluno = gerAluno.findById(id);
		aluno = lerInformacoes(aluno);
		aluno.getTelefones();
		for (Telefone telefone : aluno.getTelefones()) 
		{
			telefone.setDdd(console.readInt("DDD: "));
			telefone.setTelefone(console.readInt("Telefone: "));
		}
		gerAluno.update(aluno);	
	}

	public void deletarAluno()
	{
		int id = console.readInt("ID do aluno a ser removido: ");
		Aluno aluno = gerAluno.findById(id);
		gerAluno.remove(aluno);	
	}

	private void showMenuCurso() 
	{
		System.out.println("1: Cadastrar Curso");
		System.out.println("2: Listar Cursos");
		System.out.println("3: Atualizar Curso");
		System.out.println("4: Remover Curso");
		System.out.println("6: Voltar");
	}

	private void opcoesCurso(int opcao) 
	{
		while(opcao != VOLTAR)
		{	
			showMenuCurso();
			opcao = console.readInt("Opcao: ");
			
			if (opcao == CADASTRAR)
			{
				cadastrarCurso();
			}
			if (opcao == LISTAR)
			{
				listarCurso();
			}
			if (opcao == ATUALIZAR)
			{
				atualizarCurso();
			}
			if (opcao == REMOVER)
			{
				deletarCurso();
			}
		}
	}

	private void cadastrarCurso()
	{
		Curso curso = new Curso();
		curso.setNome(console.readLine("Nome do novo curso: "));
		gerCurso.save(curso);
	}

	private void listarCurso()
	{
		int qtd = console.readInt("Quantidade: ");
		
		List<Curso> listaCurso = gerCurso.list(qtd);
		
		for (Curso curso : listaCurso) 
		{
			System.out.println("ID: " + curso.getId());
			System.out.println("Nome: " + curso.getNome());
			
			System.out.println("");
		}
	}

	private void atualizarCurso() 
	{
		int id = console.readInt("ID do curso a ser atualizado: ");
		Curso curso = gerCurso.findById(id);
		curso.setNome(console.readLine("Novo nome do curso: "));
		gerCurso.update(curso);
		System.out.println("");
	}

	private void deletarCurso() 
	{
		int id = console.readInt("ID do curso a ser removido: ");
		Curso curso = gerCurso.findById(id);
		gerCurso.remove(curso);
		System.out.println("");
	}

	private void showMenuDisciplina() 
	{
		System.out.println("1: Cadastrar Disciplina");
		System.out.println("2: Listar Disciplinas");
		System.out.println("3: Atualizar Disciplina");
		System.out.println("4: Remover Disciplina");
		System.out.println("6: Voltar");
	}

	private void opcoesDisciplina(int opcao) 
	{
		while(opcao != VOLTAR)
		{	
			showMenuDisciplina();
			opcao = console.readInt("Opcao: ");
			
			if (opcao == CADASTRAR)
			{
				cadastrarDisciplina();
			}
			if (opcao == LISTAR)
			{
				listarDisciplina();
			}
			if (opcao == ATUALIZAR)
			{
				atualizarDisciplina();
			}
			if (opcao == REMOVER)
			{
				deletarDisciplina();
			}
		}
	}

	private void cadastrarDisciplina() 
	{
		Disciplina disciplina = new Disciplina();
		disciplina.setNome(console.readLine("Nome da nova disciplina: "));
		gerDisciplina.save(disciplina);
	}

	private void listarDisciplina() 
	{
		int qtd = console.readInt("Quantidade: ");
		
		List<Disciplina> listaDisciplina = gerDisciplina.list(qtd);
		
		for (Disciplina disciplina : listaDisciplina) 
		{
			System.out.println("ID: " + disciplina.getId());
			System.out.println("Nome: " + disciplina.getNome());
			
			System.out.println("");
		}
	}

	private void atualizarDisciplina() 
	{
		int id = console.readInt("ID da disciplina a ser atualizada: ");
		Disciplina disciplina = gerDisciplina.findById(id);
		disciplina.setNome(console.readLine("Novo nome da discplina: "));
		gerDisciplina.update(disciplina);
	}

	private void deletarDisciplina() 
	{
		int id = console.readInt("ID da disciplina a ser removida: ");
		Disciplina disciplina = gerDisciplina.findById(id);
		gerDisciplina.remove(disciplina);
		System.out.println("");
	}

	private void cadastrarAlunoCurso() 
	{
		Curso curso = gerCurso.findById(console.readInt("Id do curso: "));
		Aluno aluno = gerAluno.findById(console.readInt("Id do aluno: "));
		
		List<Aluno> alunosNoCurso = curso.getAlunosNoCurso();
		alunosNoCurso.add(aluno);
		curso.setAlunosNoCurso(alunosNoCurso);
		gerCurso.update(curso);
	}

	private void cadastrarDisciplinaAluno() 
	{
		DisciplinaAluno relacao = new DisciplinaAluno();
		Aluno aluno = gerAluno.findById(console.readInt("Id do aluno: "));
		relacao.setAluno(aluno);
		Disciplina disciplina = gerDisciplina.findById(console.readInt("Id da disciplina: "));
		relacao.setDisciplina(disciplina);
		gerDisciplinaAluno.save(relacao);
	}
}