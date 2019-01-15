package ifpr.produto;

import java.math.BigDecimal;

import java.util.Date;

public class Produto {

	private int ID;
	private int quantidade;
	private String nome;
	private BigDecimal preco;
	private Date dataValidade;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date date) {
		this.dataValidade = date;
	}

}
