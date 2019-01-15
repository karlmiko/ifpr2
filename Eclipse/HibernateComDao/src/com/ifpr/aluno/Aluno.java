package com.ifpr.aluno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.ifpr.disciplinaAluno.DisciplinaAluno;
import com.ifpr.endereco.Endereco;
import com.ifpr.telefone.Telefone;

@Entity
@Table(name = "tbAluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String login;
	private String senha;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	
	private Date dataNascimento;
	private String matricula;
	
	@JoinColumn(name = "id_endereco", referencedColumnName ="id_endereco")
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@JoinColumn(name = "id_aluno", referencedColumnName = "id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	@JoinColumn(name = "id_aluno", referencedColumnName = "id")
	@OneToMany (fetch = FetchType.EAGER)
	private List<DisciplinaAluno> disciplinaAluno = new ArrayList<DisciplinaAluno>();

	public Aluno()
	{
		this.endereco = new Endereco();
	}
	
	public List<Telefone> getTelefones() 
	{
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) 
	{
		this.telefones = telefones;
	}
	
	public void setId(int id) {

		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
