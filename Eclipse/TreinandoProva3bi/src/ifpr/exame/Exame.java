package ifpr.exame;

import ifpr.pacienteExame.PacienteExame;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbExame")
public class Exame 
{
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@JoinColumn(name= "id_exame", referencedColumnName = "id")
	@OneToMany(fetch = FetchType.EAGER)
	List<PacienteExame> pacientes = new ArrayList<PacienteExame>();

	public int getId()
	{
		return id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
}
