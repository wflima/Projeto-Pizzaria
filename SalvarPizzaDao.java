package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import br.com.zmap.modelo.Pizza;
import br.com.zmap.util.Conexao;

public class SalvarPizzaDao {
	
	
	
	public void incluirPizza(Pizza pizza) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "INSERT INTO pizza( nome, ingreditentes) VALUES (?, ?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pizza.getNome());
		ps.setString(2,pizza.getIngre_pizza());
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	public void alterarPizza(Pizza pizza) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "UPDATE pizza  SET nome=?, ingreditentes=? WHERE id_pizza=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pizza.getNome());
		ps.setString(2,pizza.getIngre_pizza());
		ps.setLong(3, pizza.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	public void removerPizza(Pizza pizza) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "DELETE FROM pizza WHERE id_pizza=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, pizza.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	public Pizza pesquisarTodasPizzaPorId(Long id) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "SELECT id_pizza, nome, ingreditentes  FROM pizza WHERE id_pizza=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1,id);
		ResultSet rs = ps.executeQuery();
		Pizza pizza = new Pizza();
		if(rs.next()) {
			pizza.setId(rs.getLong("id_pizza"));
			pizza.setNome(rs.getString("nome"));
			pizza.setIngre_pizza(rs.getString("ingreditentes"));
		}
		rs.close();
		ps.close();
		con.close();
		return pizza;
		
		}
	
	public List<Pizza> listarTodasPizzas() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "SELECT id_pizza, nome, ingreditentes FROM pizza;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Pizza> listaRetorno = new ArrayList<Pizza>();
		while (rs.next()){
			Pizza pizza = new Pizza();
			pizza.setId(rs.getLong("id_pizza"));
			pizza.setNome(rs.getString("nome"));
			pizza.setIngre_pizza(rs.getString("ingreditentes"));
			pizza.setQuantidade(0);
			listaRetorno.add(pizza);
			
		}
	
		 rs.close();
		 ps.close();
		 con.close();
		 return listaRetorno;
	}
	

}






