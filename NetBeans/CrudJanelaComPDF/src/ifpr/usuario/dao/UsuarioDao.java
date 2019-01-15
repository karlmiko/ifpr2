/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpr.usuario.dao;

import ifpr.dao.Dao;
import ifpr.usuario.Usuario;
import java.util.List;

/**
 *
 * @author ifpr
 */
public interface UsuarioDao extends Dao<Usuario>{
    public Usuario procurarPorMatricula(String matricula); 
    public List<Usuario> procurarPorNome(String nome); 
}
