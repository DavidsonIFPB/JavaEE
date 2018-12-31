package br.com.loopback.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");//força o carregamento do driver
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/cjweb1","postgres","root@123");
			System.out.println("Conexão Bem sucedida");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("Conexão Falhou");
		}
		
		
		return con;
		
	}
}
