package ifpr.pessoa.medico;

import javax.persistence.Entity;
import ifpr.pessoa.Pessoa;

@Entity
public class Medico extends Pessoa
{
	private String especialidade;

	public String getEspecialidade() 
	{
		return especialidade;
	}

	public void setEspecialidade(String especialidade) 
	{
		this.especialidade = especialidade;
	}
}
