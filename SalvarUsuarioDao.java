package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.zmap.modelo.Usuario;
import br.com.zmap.util.Conexao;

public class SalvarUsuarioDao {
	
	
	public void incluirUsuario(Usuario usuario ) throws ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "INSERT INTO usuario(login, senha)  VALUES (?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, usuario.getLogin());
		ps.setString(2, usuario.getSenha());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public void alterarUsuario(Usuario usuario ) throws ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "UPDATE usuario  SET login=?, senha=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, usuario.getLogin());
		ps.setString(2, usuario.getSenha());
		ps.setLong(3, usuario.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public void removerUsuario(Usuario usuario ) throws ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "DELETE FROM usuario WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, usuario.getId());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
  
	public Usuario pesquisarTodosUsuario(Long id) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "SELECT id, login, senha  FROM usuario WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		Usuario usuario = new Usuario();
		if (rs.next()) {
			usuario.setId(rs.getLong("id"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			
		}
		rs.close();
		ps.close();
		con.close();
		return usuario;
	}
	 
	public List<Usuario> ListarTodosUsuarios() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "SELECT id, login, senha  FROM usuario";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Usuario> listaRetorno = new ArrayList<Usuario>();
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			listaRetorno.add(usuario);
		}
		 rs.close();
		 ps.close();
		 con.close();
		return listaRetorno;
		
	}

}
