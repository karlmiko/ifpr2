package ifpr.pacienteExame;

import ifpr.exame.Exame;
import ifpr.pessoa.Pessoa;
import ifpr.pessoa.paciente.Paciente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbPacienteExame")
public class PacienteExame 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn (name="id_exame", referencedColumnName="id")
	@ManyToOne()
	Exame exame = new Exame();
	
	@JoinColumn (name="id_paciente", referencedColumnName="id")
	@ManyToOne()
	Pessoa paciente = new Paciente();

	public int getId() 
	{
		return id;
	}

	public Exame getExame()
	{
		return exame;
	}

	public void setExame(Exame exame)
	{
		this.exame = exame;
	}

	public Pessoa getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Pessoa paciente) 
	{
		this.paciente = paciente;
	}
}
