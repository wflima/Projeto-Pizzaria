package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import br.com.zmap.modelo.Pizza;
import br.com.zmap.util.Conexao;

public class IncluirPizzaDao {
	
	public void incluirPizza(Pizza pizza) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "INSERT INTO pedido( tipo_produto, codigo_produto, qtde_produto, co_mesa, status )    VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1,1);
		ps.setLong(2,pizza.getId());
		ps.setLong(3,pizza.getQuantidade());
		ps.setLong(4,pizza.getCoMesa());
		ps.setLong(5,0);
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	

}
