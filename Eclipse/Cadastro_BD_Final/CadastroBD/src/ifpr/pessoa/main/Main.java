package ifpr.pessoa.main;

import ifpr.console.Console;
import ifpr.gerenciador.Gerenciador;
import ifpr.produto.Produto;
import ifpr.produto.ProdutoDAO;
import ifpr.singleton.MySingleton;
import ifpr.usuario.Usuario;
import ifpr.usuario.UsuarioDAO;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Main {
	
	@SuppressWarnings("rawtypes")
	private Gerenciador gerenciador;
	private Console console;

	private final int USUARIO = 1;
	private final int PRODUTO = 2;
	private final int SAIR = 3;
	
	private final int INSERIR = 1;
	private final int CONSULTAR = 2;
	private final int ATUALIZAR = 3;
	private final int REMOVER = 4;
	private final int FECHAR = 5;

	public Main() {
		console = new Console();
	}

	public static void main(String[] args) {
		new Main().executar();
	}

	public void executar() {
		
		int escolhaMenu = 0;
		do {
			printMenuInicial();
			System.out.print("Escolha: ");
			escolhaMenu = console.readInt();

			if (escolhaMenu == USUARIO) {
				gerenciador = new UsuarioDAO();
				
			} else if (escolhaMenu == PRODUTO) {
				gerenciador = new ProdutoDAO();
			
			}
			
			if (escolhaMenu != SAIR){
			
				int escolha = 0;
				do {
					printMenu();
					System.out.print("Escolha: ");
					escolha = console.readInt();

					if (escolha == INSERIR) {
						inserir();
					} else if (escolha == CONSULTAR) {
						consultar();
					} else if (escolha == ATUALIZAR) {
						atualizar();
					} else if (escolha == REMOVER) {
						remover();
					}

				} while (escolha != FECHAR);				
			}
		} while (escolhaMenu != SAIR);

		MySingleton.closeConnection();
		System.out.println("Programa encerrado!");
	}

	@SuppressWarnings("unchecked")
	private void inserir() {
		if (gerenciador instanceof UsuarioDAO) {
			Usuario usuario = new Usuario();
			gerenciador.inserir(novoUsuario(usuario));
		} else {
			Produto produto = new Produto();
			gerenciador.inserir(novoProduto(produto));	
		}
		System.out.println("Inserido com sucesso");
	}

	private Usuario novoUsuario(Usuario usuario) {
		System.out.print("Nome: ");
		usuario.setNome(console.readString());
		System.out.print("Login: ");
		usuario.setLogin(console.readString());
		System.out.print("Senha: ");
		usuario.setSenha(console.readString());
		return usuario;
	}
	
	private Produto novoProduto(Produto produto) {
		System.out.print("Nome: ");
		produto.setNome(console.readString());
		System.out.print("Preco: ");
		produto.setPreco(new BigDecimal(console.readFloat()));
		System.out.print("Validade: ");
		produto.setDataValidade(console.readDate());
		System.out.print("Quanidade: ");
		produto.setQuantidade(console.readInt());
		return produto;
	}

	private void printMenuInicial() {
		console.printMessage("+-----------------------+");
		console.printMessage("|1 - Gerenciar Usuários |");
		console.printMessage("|2 - Gerenciar Produtos |");
		console.printMessage("|3 - Sair               |");
		console.printMessage("+-----------------------+");
	}
	
	private void printMenu() {
		console.printMessage("+---------------+");
		console.printMessage("|   Gerenciar   |");
		console.printMessage("|1 - Inserir    |");
		console.printMessage("|2 - Consultar  |");
		console.printMessage("|3 - Atualizar  |");
		console.printMessage("|4 - Remover    |");
		console.printMessage("|5 - Fechar     |");
		console.printMessage("+---------------+");
	}

	private void consultar() {
	List<?> objetos = gerenciador.listar();
	Iterator<?> objetosIter = objetos.iterator();
	
	while( objetosIter.hasNext()) {
			System.out.println("+--------------------+");
			System.out.println(printDados(objetosIter.next()));
		}
	}

	@SuppressWarnings("unchecked")
	private void atualizar() {

		System.out.print("ID: ");
		int ID = console.readInt();
		
		if (gerenciador instanceof UsuarioDAO) {
			
			Usuario usuario = null;
			try {
				usuario = (Usuario) gerenciador.pesquisaID(ID);
				novoUsuario(usuario);
				gerenciador.atualizar(ID, usuario);
			} catch (Exception e) {
				System.err.println("Usuário não encontrado.");
				return;
			}
		} else {
			Produto produto = null;
			try {
				produto = (Produto) gerenciador.pesquisaID(ID);
				novoProduto(produto);
				gerenciador.atualizar(ID, produto);
			} catch (Exception e) {
				System.err.println("Produto não encontrado.");
				return;
			}
		}
		System.out.println("Alterado com Sucesso");
	}
	
	private void remover() {
		
		System.out.print("ID: ");
		int ID = console.readInt();
		try {
			gerenciador.pesquisaID(ID);
			gerenciador.remover(ID);
			System.out.println("Elemento Removido!");
		} catch (Exception e) {
			System.err.println("Não encontrado.");
		}
	}
	
	public String printDados(Object object) {
		if (gerenciador instanceof UsuarioDAO) {
			Usuario usuario = (Usuario) object;
			return "ID: " + usuario.getId() 
				+ "\nNome: " + usuario.getNome() 
				+ "\nLogin: " + usuario.getLogin() 
				+ "\nSenha: " + usuario.getSenha();
		} else{
			Produto produto = (Produto) object;
			return "ID: " + produto.getID() 
				+ "\nNome: "+ produto.getNome() 
				+ "\nPreco: " + produto.getPreco() 
				+ "\nQuantidade: " + produto.getQuantidade() 
				+ "\nValidade: "+ dataFormatar(produto.getDataValidade());
		}
	}
	
	private String dataFormatar(Date data){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data).toString();
	}
}