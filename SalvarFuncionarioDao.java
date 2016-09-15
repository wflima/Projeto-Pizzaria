package br.com.faculdadeDelta.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zmap.modelo.Funcionario;
import br.com.zmap.util.Conexao;

public class SalvarFuncionarioDao {
	
	public void incluirFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "INSERT INTO funcionarios( nome, sexo, idade, rg, cpf, endereco, data)  VALUES (?, ?, ?, ?, ?, ?, ? )";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, funcionario.getNome());
		ps.setString(2, funcionario.getSexo());
		ps.setString(3, funcionario.getIdade());
		ps.setString(4,funcionario.getRg());
		ps.setString(5, funcionario.getCpf());
		ps.setString(6, funcionario.getEndereço());
		ps.setDate(7, new Date (funcionario.getDataAdmicao().getTime()));
		ps.execute();
		ps.close();
		con.close();
		
	}
	public void alterarFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "UPDATE funcionarios   SET nome=?, sexo=?, idade=?, rg=?, cpf=?, endereco=?, data=? WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, funcionario.getNome());
		ps.setString(2, funcionario.getSexo());
		ps.setString(3, funcionario.getIdade());
		ps.setString(4,funcionario.getRg());
		ps.setString(5, funcionario.getCpf());
		ps.setString(6, funcionario.getEndereço());
		ps.setDate(7, new Date (funcionario.getDataAdmicao().getTime()));
		ps.setLong(8,funcionario.getId());
		ps.execute();
		ps.close();
		con.close();
	}
	public void removerFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection con = conexao.conetarNoBancoDeDados();
		String sql = "DELETE FROM funcionarios WHERE id=?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, funcionario.getId());
		ps.execute();
		ps.close();
		con.close();
	
	 }
	 public List<Funcionario> listarTodosFuncionarios() throws ClassNotFoundException, SQLException {
		 Conexao conexao = new Conexao();
		 Connection con = conexao.conetarNoBancoDeDados();
		 String sql = "SELECT f.id AS id, f.nome AS nome, f.idade AS idade, f.rg AS rg, f.cpf AS cpf, f.endereco As endereco, "
		 		+ "f.data AS data , f.sexo AS sexo FROM funcionarios f"	;
		 PreparedStatement ps = con.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 List<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		 while(rs.next()){
			 Funcionario funcionario = new Funcionario();
			 	funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setIdade(rs.getString("idade"));
				funcionario.setRg(rs.getString("rg"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setEndereço(rs.getString("endereco"));
				funcionario.setDataAdmicao(rs.getDate("data"));	
				funcionario.setSexo(rs.getString("sexo"));
				listaRetorno.add(funcionario);
		 }
		 	rs.close();
			ps.close();
			con.close();
			return listaRetorno;
	 }
	 
}
