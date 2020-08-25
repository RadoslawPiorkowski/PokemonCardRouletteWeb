package com.pokemonCardRouletteWeb;

import java.sql.*;

public class BazaDanych {
	
	public static String urlBazy = "jdbc:postgresql:pokemon";
	public static String uzytkownik = "postgres";
	public static String hasloBazyDanych = "425@hejBudowa";
	
	
	public static Statement getStatmentBD() throws SQLException{
				
		Connection connection = DriverManager.getConnection(urlBazy, uzytkownik, hasloBazyDanych);
		
		return connection.createStatement();

	}
	

	
	


}
