package br.com.vsetsistemas.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.vsetsistemas.db.ConnectDB;

@SuppressWarnings("unused")
public class DAO {
	protected ConnectDB db;
	protected Connection connection;
	
	public DAO() {
		//Inicializar ConnectDB
		db = new ConnectDB();
	}
	
	/**
	 * Realizar conexão com o BD
	 * @throws Exception 
	 */
	public void conectar() throws Exception {
		if(connection == null)
			connection = db.getConnection();
	}
	
	/**
	 * Desconectar com o BD
	 * @throws Exception 
	 */
	public void desconectar() throws Exception {
		if(connection != null)
			connection.close();
	}
}
