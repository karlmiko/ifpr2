package ifpr.produto;

import ifpr.gerenciador.Gerenciador;
import ifpr.singleton.MySingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements Gerenciador<Produto>{
	
	PreparedStatement pStm;
	
	@Override
	public void inserir(Produto produto){
		String sql="insert into tbProdutos (nome_produto, quantidade_produto, preco_produto, validade_produto) values (?, ?, ?, ?)";
		try {
			pStm = MySingleton.getConnection().prepareStatement(sql);
			pStm.setString(1, produto.getNome());
			pStm.setInt(2, produto.getQuantidade());
			pStm.setBigDecimal(3, produto.getPreco());
			pStm.setDate(4, new java.sql.Date(produto.getDataValidade().getTime()));
			pStm.execute();
			pStm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Produto> listar()
	{
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "select * from tbProdutos";
		try
		{
			pStm = MySingleton.getConnection().prepareStatement(sql);
			ResultSet rs = pStm.executeQuery();
			while ( rs.next() )
			{
				Produto produto = criarProduto(rs);
				produtos.add(produto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return produtos;
	}
	
	@Override
	public void atualizar(int ID, Produto produto){
		
		String sql= "update tbprodutos set nome_produto = ?" +
				",quantidade_produto = ?, preco_produto = ?, validade_produto = ? where id = ?";
		try {
			pStm = MySingleton.getConnection().prepareStatement(sql);
			pStm.setString(1, produto.getNome());
			pStm.setInt(2, produto.getQuantidade());
			pStm.setBigDecimal(3, produto.getPreco());
			pStm.setDate(4, new java.sql.Date(produto.getDataValidade().getTime()));
			pStm.setInt(5, ID);
			pStm.execute();
			pStm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void remover(int ID){
		String sql="delete from tbProdutos where id = ?";
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
	public Produto pesquisaID(int ID) throws Exception {
		
		String sql= "SELECT * from tbProdutos where id = ?";
		Produto produto = null;
		try {
			pStm = MySingleton.getConnection().prepareStatement(sql);
			pStm.setInt(1, ID);
			ResultSet rs = pStm.executeQuery();
			rs.next();
			produto = criarProduto(rs);
			pStm.close();
			
		} catch (SQLException e) { 
			throw new Exception("Ninguém encontrado");
			
		}
		return produto;		
	}
	
	private Produto criarProduto(ResultSet rs) throws SQLException {
		Produto produto = new Produto();
		produto.setID(rs.getInt("id"));
		produto.setNome(rs.getString("nome_produto"));
		produto.setQuantidade(rs.getInt("quantidade_produto"));
		produto.setPreco(rs.getBigDecimal("preco_produto"));
		produto.setDataValidade(rs.getDate("validade_produto"));
		return produto;
	}
}
