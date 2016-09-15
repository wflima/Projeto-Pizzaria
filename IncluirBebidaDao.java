package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import br.com.zmap.modelo.Bebida;
import br.com.zmap.util.Conexao;

public class IncluirBebidaDao {
	
	public void incluirBebida(Bebida bebida) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "INSERT INTO pedido( tipo_produto, codigo_produto, qtde_produto, co_mesa, status, id_bebida )   VALUES (?, ?, ?, ?, ?, ?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1,0);
		ps.setLong(2,bebida.getId());
		ps.setLong(3, bebida.getQuantidade());
		ps.setLong(4, bebida.getCoMesa());
		ps.setLong(5,0);
		ps.setLong(6,bebida.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}

}
