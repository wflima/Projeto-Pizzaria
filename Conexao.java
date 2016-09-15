package br.com.zmap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	
	public Connection conetarNoBancoDeDados() throws SQLException, 
	ClassNotFoundException{ 

Class.forName("org.postgresql.Driver");
String url = "jdbc:postgresql://localhost:5432/zmap";
String usaruario = "wflima";
String senha = "8154";
Connection Conexao = DriverManager.getConnection(url, usaruario, senha);

	return Conexao;
	}

public static void main(String[] args) {
Conexao conexao = new Conexao();
try {
	conexao.conetarNoBancoDeDados();
	System.out.print("Conexão estabalecida com sucesso!");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
} catch (SQLException e) {
	e.printStackTrace();
	
	}
}


}
