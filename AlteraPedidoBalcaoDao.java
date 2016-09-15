package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import br.com.zmap.modelo.Pedido;
import br.com.zmap.util.Conexao;



public class AlteraPedidoBalcaoDao {
	
	
	public void alteraPedioBalcao(Pedido pedido) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "UPDATE pedido SET status=?   WHERE  id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, 2);
		ps.setLong(2, pedido.getId());
		ps.executeUpdate();
		ps.close();
		ps.close();
		con.close();
	}
	
	public List<Pedido> listarTodosPedidosBalcao() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "SELECT *  FROM pedido  where status=1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Pedido> listaRetorno = new ArrayList<Pedido>();
		while(rs.next()) {
			Pedido pedido = new Pedido();
			pedido.setId(rs.getLong("id"));
			pedido.setTipoProduto(rs.getLong("tipo_produto"));

			pedido.setCoProduto(rs.getLong("codigo_produto"));
			pedido.setDescricao( buscaNomeProduto(rs.getLong("tipo_produto"), rs.getLong("codigo_produto")) );
			
			pedido.setQtdeProduto(rs.getLong("qtde_produto"));
			pedido.setCoMesa(rs.getLong("co_mesa"));
			pedido.setStatus(rs.getLong("status"));
			listaRetorno.add(pedido);

		}
		rs.close();
		ps.close();
		con.close();
		return listaRetorno;

	}

	public String buscaNomeProduto(long tipo, long codProduto) throws SQLException, ClassNotFoundException {

		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "";
		String nome = "";
		if (tipo == 1) {

			sql = "SELECT *  FROM pedido p";
			sql += " join pizza pi on pi.id_pizza = p.codigo_produto";
			sql += " where p.status=1";
			sql += " and p.codigo_produto = " + codProduto;
					
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nome = rs.getString("nome");
			}
			rs.close();
			ps.close();
			con.close();
			return nome;

		} else {

			sql = "SELECT *  FROM pedido p";
			sql += " join bebida be on be.id = p.codigo_produto";
			sql += " where p.status=1";
			sql += " and p.codigo_produto = " + codProduto;
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nome = rs.getString("descricao");
			}
			rs.close();
			ps.close();
			con.close();
			return nome;
		}
		
	}

}
