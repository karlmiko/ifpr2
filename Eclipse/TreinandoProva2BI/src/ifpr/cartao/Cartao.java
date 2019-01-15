package ifpr.cartao;

public class Cartao 
{
	private int id_cartao;
	private String tipo;
	private String remetente;
	private String destinatario;
	private String texto;
	
	public int getId_cartao() 
	{
		return id_cartao;
	}
	
	public void setId_cartao(int id_cartao) 
	{
		this.id_cartao = id_cartao;
	}
	
	public String getTipo() 
	{
		return tipo;
	}
	
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
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