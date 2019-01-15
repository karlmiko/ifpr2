package ifpr.pessoa.paciente;

import java.util.ArrayList;
import java.util.List;

import ifpr.pacienteExame.PacienteExame;
import ifpr.pessoa.Pessoa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Paciente extends Pessoa
{
	private int rg;
	private int cpf;
	
	@JoinColumn(name="id_paciente", referencedColumnName = "id")
	@OneToMany(fetch=FetchType.EAGER)
	List <PacienteExame> exames = new ArrayList<PacienteExame>();

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public List<PacienteExame> getExames() {
		return exames;
	}

	public void setExames(List<PacienteExame> exames) {
		this.exames = exames;
	}
}
