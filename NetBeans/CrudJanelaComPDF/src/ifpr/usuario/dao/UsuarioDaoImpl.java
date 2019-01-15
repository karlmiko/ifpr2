/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.usuario.dao;

import ifpr.dao.GenericDao;
import ifpr.singleton.EntitySingleton;
import ifpr.usuario.Usuario;
import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author ifpr
 */
public class UsuarioDaoImpl extends GenericDao<Usuario> implements UsuarioDao {

    public UsuarioDaoImpl() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario procurarPorMatricula(String matricula){
        Query query = EntitySingleton.getEntityManager().createQuery("from Usuario u where u.matricula = :mat");
        query.setParameter("mat", matricula);
        return (Usuario)query.getSingleResult();
    }

    @Override
    public List<Usuario> procurarPorNome(String nome) {
        Query query = EntitySingleton.getEntityManager().createQuery("from Usuario u where lower(u.nome) like  concat('%', :nome,'%')");
        query.setParameter("nome", nome.toLowerCase());
        return query.getResultList();
    }
    
}
