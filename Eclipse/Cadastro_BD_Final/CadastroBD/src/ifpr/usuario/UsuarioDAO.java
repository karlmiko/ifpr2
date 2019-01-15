package ifpr.usuario;

import ifpr.gerenciador.Gerenciador;
import ifpr.singleton.MySingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements Gerenciador <Usuario> {

	private PreparedStatement pStm;
	
	@Override
	public void inserir(Usuario usuario){
		String sql="insert into tbUsuarios (nome_usuario, login_usuario, senha_usuario) values (?, ?, ?)";
		try {
			pStm = MySingleton.getConnection().prepareStatement(sql);
			pStm.setString(1, usuario.getNome());
			pStm.setString(2, usuario.getLogin());
			pStm.setString(3, usuario.getSenha());
			pStm.execute();
			pStm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Usuario> listar()
	{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from tbUsuarios";
		try
		{
			pStm = MySingleton.getConnection().prepareStatement(sql);
			ResultSet rs = pStm.executeQuery();
			while ( rs.next() )
			{
				Usuario usuario = criarUsuario(rs);
				usuarios.add(usuario);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return usuarios;
	}
	
	@Override
	public void atualizar(int ID, Usuario usuario){
		
		String sql= "update tbUsuarios set nome_usuario = ?" +
				",login_usuario = ?, senha_usuario = ? where id = ?";
		try {
			pStm = MySingleton.getConnection().prepareStatement(sql);
			pStm.setString(1, usuario.getNome());
			pStm.setString(2, usuario.getLogin());
			pStm.setString(3, usuario.getSenha());
			pStm.setInt(4, ID);
			pStm.execute();
			pStm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public void remover(int ID){
		String sql="delete from tbUsuarios where id = ?";
		try {
			pStm = MySingleton.getConnection().prepareStatement(sql);
			pStm.setInt(1, ID);
			pStm.execute();
			pStm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Usuario pesquisaID(int ID) throws Exception {
		
		String sql="SELECT * from tbUsuarios where id = ?";
		Usuario usuario = null;
		try {
			pStm = MySingleton.getConnection().prepareStatement(sql);
			pStm.setInt(1, ID);
			ResultSet rs = pStm.executeQuery();
			rs.next();
			usuario = criarUsuario(rs);
			pStm.close();
			
		} catch (SQLException e) { 
			throw new Exception("Ninguém encontrado");
			
		}
		return usuario;		
	}
	
	private Usuario criarUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setNome(rs.getString("nome_usuario"));
		usuario.setLogin(rs.getString("login_usuario"));
		usuario.setSenha(rs.getString("senha_usuario"));
		return usuario;
	}
}
