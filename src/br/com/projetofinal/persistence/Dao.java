package br.com.projetofinal.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	public Connection con;
	public ResultSet rs;
	public PreparedStatement stmt;
	
	/**
	 * Abre a conex�o
	 * @throws Exception
	 */
	public void open( )throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/TccDpaVersao3","root","371casa1");
	}
	
	/**
	 * Fecha a conex�o
	 * @throws Exception
	 */
	public void close( )throws Exception{
		con.close();
	}
	
	/**
	 * Respos�vel por testar a conex�o
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
				Dao d = new Dao();
				d.open();
				d.close();
				System.out.println("Aberta com sucesso!!!");
			} catch (Exception e) {
				System.out.println("Deu merda!!!");
		}

	}
}
