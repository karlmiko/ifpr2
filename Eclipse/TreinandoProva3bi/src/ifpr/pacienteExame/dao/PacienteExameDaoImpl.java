package ifpr.pacienteExame.dao;

import ifpr.dao.GenericDao;
import ifpr.pacienteExame.PacienteExame;

public class PacienteExameDaoImpl extends GenericDao<PacienteExame> implements PacienteExameDao
{

	public PacienteExameDaoImpl(Class<PacienteExame> classe)
	{
		super(PacienteExame.class);
	}	
}
