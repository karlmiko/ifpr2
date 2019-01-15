package ifpr.computador.gerenciarComputador;

import ifpr.computador.Computador;
import ifpr.singleton.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciarComputador 
{
	private PreparedStatement pstm;
	
	public void inserir(Computador pc) 
	{
		String sql = "insert into tb_computador (marca,qtdMemoriaRam)values(?,?)";
		
		try
		{
			pstm = Singleton.getConnection().prepareStatement(sql);
			pstm.setString(1, pc.getMarca());
			pstm.setInt(2, pc.getQtdMemoriaRam());
			pstm.execute();
			pstm.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void remover(Computador pc) 
	{
		String sql = "delete from tb_computador where id_computador = ?";
		
		try
		{
			pstm = Singleton.getConnection().prepareStatement(sql);
			pstm.setInt(1, pc.getId());
			pstm.execute();
			pstm.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void atualizar(Computador pc) 
	{
		String sql = "update tb_computador set marca = ?, qtdMemoriaRam = ? where id_computador = ?";
		
		try
		{
			pstm = Singleton.getConnection().prepareStatement(sql);
			pstm.setString(1, pc.getMarca());
			pstm.setInt(2, pc.getQtdMemoriaRam());
			pstm.setInt(3, pc.getId());
			pstm.execute();
			pstm.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<Computador> retornaLista() 
	{
		List <Computador> computadores = new ArrayList<Computador>();
		String sql = "select * from tb_computador";
		
		try
		{
			pstm = Singleton.getConnection().prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next())
			{
				Computador pc = criarComputador(rs);
				computadores.add(pc);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return computadores;
	}

	private Computador criarComputador(ResultSet rs) throws SQLException 
	{
		Computador pc = new Computador();
		pc.setId(rs.getInt("id_computador"));
		pc.setMarca(rs.getString("marca"));
		pc.setQtdMemoriaRam(rs.getInt("qtdMemoriaRam"));
		return pc;
	}
	
}
