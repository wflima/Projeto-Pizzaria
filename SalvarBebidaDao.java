package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.zmap.modelo.Bebida;
import br.com.zmap.util.Conexao;

public class SalvarBebidaDao {
	
	
	public void incluirBebidas(Bebida bebida) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "INSERT INTO bebida( descricao, tipo, preco)  VALUES (?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bebida.getDescricao());
		ps.setString(2, bebida.getTipoBebida());
		ps.setDouble(3, bebida.getPreco());
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	public void alterarBedida(Bebida bebida) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "UPDATE bebida SET descricao=?, tipo=?, preco=? WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bebida.getDescricao());
		ps.setString(2, bebida.getTipoBebida());
		ps.setDouble(3, bebida.getPreco());
		ps.setLong(4, bebida.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public void removerBebida(Bebida bebida) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "DELETE FROM bebida WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, bebida.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public Bebida pesquisarTodasBebidasPorId(Long id) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "SELECT id, descricao, tipo, preco  FROM bebida WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		Bebida bebida = new Bebida(null);
		if(rs.next()) {
			bebida.setDescricao(rs.getString("descricao"));
			bebida.setTipoBebida(rs.getString("tipo"));
			bebida.setPreco(rs.getDouble("preco"));
			bebida.setId(rs.getLong("id"));
			
		}
		rs.close();
		ps.close();
		con.close();
		return bebida;
		
		
	}
	
	public List<Bebida> listarTodasBebidas() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "SELECT id, descricao, tipo, preco  FROM bebida;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Bebida> listaRetorno = new ArrayList<Bebida>();
		while(rs.next()) {
			Bebida bebida = new Bebida(null);
			bebida.setDescricao(rs.getString("descricao"));
			bebida.setTipoBebida(rs.getString("tipo"));
			bebida.setPreco(rs.getDouble("preco"));
			bebida.setId(rs.getLong("id"));
			bebida.setQuantidade(0);
			listaRetorno.add(bebida);
			
		}
		 rs.close();
		 ps.close();
		 con.close();
		return listaRetorno;
	}
	

}



