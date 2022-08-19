package Sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BancoDeDados {
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;

	public static Connection conectar() {
		java.sql.Connection conexao = null;
		String servidor = "jdbc:mysql://farmacia-ibm.mysql.database.azure.com:3306/ibm_farmacia?serverTimezone=UTC";
		String usuario = "Grupo6_IBM@farmacia-ibm";
		String senha = "group6_1234";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver); 
			conexao = DriverManager.getConnection(servidor, usuario, senha);
			return conexao;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
			return null;
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public java.sql.Statement getStatement() {
		return statement;
	}

	public ResultSet getResultset() {
		return resultset;
	}

}