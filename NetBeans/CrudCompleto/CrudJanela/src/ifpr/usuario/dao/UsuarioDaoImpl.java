package ifpr.usuario.dao;

import ifpr.dao.GenericDao;
import ifpr.entityManager.EntitySingleton;
import ifpr.usuario.Usuario;
import javax.persistence.Query;

public class UsuarioDaoImpl extends GenericDao<Usuario>
                implements UsuarioDao
{
    public UsuarioDaoImpl()
    {
        super(Usuario.class);
    }

    @Override
    public Usuario procurarPorMatricula(String matricula) {
        
        Query query = EntitySingleton.getEntityManager().createQuery("from Usuario u where u.matricula = :mat");
        query.setParameter("mat", matricula);
        return (Usuario)query.getSingleResult();
    } 
}