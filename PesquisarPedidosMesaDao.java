package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.zmap.modelo.Bebida;
import br.com.zmap.modelo.Pedido;
import br.com.zmap.util.Conexao;

public class PesquisarPedidosMesaDao {
	
	
	public List<Pedido>  pesquisarPedidosPorMesa(Pedido pedido) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql= "SELECT p.co_mesa As mesa, p.qtde_produto AS quantidade, bebida.preco,"
				+ " bebida.tipo, bebida.descricao FROM bebida "
				+ "	inner join pedido p on p.codigo_produto = bebida.id"
				+ "	and co_mesa =? "
				+ "and tipo_produto=0";			
		PreparedStatement ps = con.prepareStatement(sql);
		if (pedido.getCoMesa() ==null  ) {
			ps.setLong(1, 0 );
		}else{
			ps.setLong(1, pedido.getCoMesa());
		}
		ResultSet rs = ps.executeQuery();
		List<Pedido> listaRetorno = new ArrayList<Pedido>();
		while(rs.next()){
		
		Bebida bebida = new Bebida(null);
			
			bebida.setDescricao(rs.getString("descricao"));
			bebida.setTipoBebida(rs.getString("tipo"));
			bebida.setPreco(rs.getDouble("preco"));
			Pedido p = new Pedido();
			p.setObjBebida(bebida);
			p.setQtdeProduto(rs.getLong("quantidade"));
			p.setCoMesa(rs.getLong("mesa"));
			listaRetorno.add(p);
				
		}
		rs.close();
		ps.close();
		con.close();
		return listaRetorno;		
		
		}
	public void removerMesa(Pedido pedido) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "DELETE FROM pedido  WHERE co_mesa=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, pedido.getCoMesa());
		ps.executeUpdate();
		ps.close();
		con.close();
		
		}
	 
	}
