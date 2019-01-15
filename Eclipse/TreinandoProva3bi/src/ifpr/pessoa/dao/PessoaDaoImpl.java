package ifpr.pessoa.dao;

import ifpr.dao.GenericDao;
import ifpr.pessoa.Pessoa;

public class PessoaDaoImpl extends GenericDao<Pessoa> implements PessoaDao {

	public PessoaDaoImpl (Class <Pessoa> classe) 
	{
		super(Pessoa.class);
	}
}
