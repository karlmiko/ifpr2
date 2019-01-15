package ifpr.cartao;

import ifpr.console.Console;
import ifpr.console.Singleton;

public abstract class Cartao 
{	
	protected String remetente;
	protected String destinatario;
	protected String texto;
	protected Console console;
	
	public abstract void mostrarMensagem();

	public Cartao ()
	{
		console = Singleton.getInstance();
	}
	
	public void lerInformacoes()
	{
		this.setDestinatario(console.readLine("Destinatario: "));
		this.setRemetente(console.readLine("Remetente: "));
		this.setTexto(console.readLine("Texto: "));
	}
	
	public String getRemetente() 
	{
		return remetente;
	}
	
	public void setRemetente(String remetente) 
	{
		this.remetente = remetente;
	}
	
	public String getDestinatario()
	{
		return destinatario;
	}
	
	public void setDestinatario(String destinatario)
	{
		this.destinatario = destinatario;
	}
	
	public String getTexto() 
	{
		return texto;
	}
	
	public void setTexto(String texto) 
	{
		this.texto = texto;
	}
}
