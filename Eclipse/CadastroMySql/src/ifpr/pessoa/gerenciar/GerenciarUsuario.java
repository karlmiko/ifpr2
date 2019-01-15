package ifpr.pessoa.gerenciar;

import ifpr.pessoa.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciarUsuario {

	private Connection conn;
	private PreparedStatement pStm;
	
	public GerenciarUsuario() 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_aulacadastro","root", "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Usuario> getUsuarios()
	{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from tbUsuarios";
		try
		{
			pStm = conn.prepareStatement(sql);
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

	private Usuario criarUsuario(ResultSet rs) throws SQLException 
	{
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setNome(rs.getString("nome_usuario"));
		usuario.setLogin(rs.getString("login_usuario"));
		usuario.setSenha(rs.getString("senha_usuario"));
		return usuario;
	}
	
	public void cadastrar(Usuario usuario)
	{
		String sql = "INSERT INTO tbUsuarios (nome_usuario, login_usuario, senha_usuario) VALUES (?, ?, ?)";
		
		try
		{
			pStm = conn.prepareStatement(sql);
			pStm.setString(1, usuario.getNome());
			pStm.setString(2, usuario.getLogin());
			pStm.setString(3, usuario.getSenha());
			pStm.execute();
			pStm.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario)
	{
		String sql = "UPDATE tbUsuarios SET nome_usuario = ?, login_usuario = ?, senha_usuario = ? where id = ?";  
		
		try
		{
			pStm = conn.prepareStatement(sql);
			pStm.setInt(4, usuario.getId());
			pStm.setString(1, usuario.getNome());
			pStm.setString(2, usuario.getLogin());
			pStm.setString(3, usuario.getSenha());
			pStm.execute();
			pStm.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void remover (Usuario usuario)
	{
		String sql = "delete from tbUsuarios where id = ?";
		
		try
		{
			pStm = conn.prepareStatement(sql);
			pStm.setInt(1, usuario.getId());
			pStm.execute();
			pStm.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
