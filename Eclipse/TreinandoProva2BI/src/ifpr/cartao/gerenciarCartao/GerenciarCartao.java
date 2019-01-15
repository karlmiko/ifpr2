package ifpr.cartao.gerenciarCartao;

import ifpr.cartao.Cartao;
import ifpr.singleton.Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciarCartao 
{
	private PreparedStatement pStm;
	
	public void inserirCartao (Cartao cartao)
	{
		String sql = "insert into tbCartao (tipo,remetente,destinatario,texto) values (?,?,?,?)";
		try 
		{
			pStm = Singleton.getConnection().prepareStatement(sql);
			pStm.setString(1, cartao.getTipo());
			pStm.setString(2, cartao.getRemetente());
			pStm.setString(3, cartao.getDestinatario());
			pStm.setString(4, cartao.getTexto());
			pStm.execute();
			pStm.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
	
	public List<Cartao> listarCartoes()
	{
		List<Cartao> listaCartoes = new ArrayList<Cartao>();
		
		String sql = "select * from tbCartao";
		
		try 
		{	
			pStm = Singleton.getConnection().prepareStatement(sql);
			ResultSet rs = pStm.executeQuery();
			
			while (rs.next())
			{
				Cartao cartao = criarCartao(rs);
				listaCartoes.add(cartao);
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return listaCartoes;
	}

	private Cartao criarCartao(ResultSet rs) throws SQLException 
	{
		Cartao cartao = new Cartao();
		cartao.setId_cartao(rs.getInt("id_cartao"));
		cartao.setRemetente(rs.getString("remetente"));
		cartao.setDestinatario(rs.getString("destinatario"));
		cartao.setTexto(rs.getString("texto"));
		cartao.setTipo(rs.getString("tipo"));
		return cartao;
	}
}
