package ifpr.usuario.dao;

import ifpr.dao.GenericDao;
import ifpr.usuario.Usuario;

public class UsuarioDaoImpl extends GenericDao<Usuario>
                implements UsuarioDao
{
    public UsuarioDaoImpl()
    {
        super(Usuario.class);
    }
}