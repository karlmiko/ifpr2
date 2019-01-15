package ifpr.cartao;

import ifpr.console.Console;
import ifpr.console.SingletonConsole;

public abstract class Cartao {

	protected int id;
	protected String remetente;
	protected String destinatario;
	protected String mensagem;
	protected Console console;
	
	public abstract void mostrarMensagem();
	
	public Cartao() {
		console = SingletonConsole.getInstance();
	}
	
	public void lerDados()
	{
		this.setRemetente(console.readLine("Remetente: "));
		this.setDestinatario(console.readLine("Destinatário: "));
		this.setMensagem(console.readLine("Mensagem: "));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
