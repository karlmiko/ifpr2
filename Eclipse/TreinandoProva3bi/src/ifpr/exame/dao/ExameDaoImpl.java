package ifpr.exame.dao;

import ifpr.dao.GenericDao;
import ifpr.exame.Exame;

public class ExameDaoImpl extends GenericDao<Exame> implements ExameDao
{
	public ExameDaoImpl(Class<Exame> classe)
	{
		super(Exame.class);
	}
}
