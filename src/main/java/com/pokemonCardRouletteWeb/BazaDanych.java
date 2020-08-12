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
	
	public static boolean czyDaneNieSaZajete(String nick, String mail) throws SQLException {
		ResultSet sprNick = getStatmentBD().executeQuery("SELECT COUNT (nick) FROM gracz where nick = '"+nick+"';");
		ResultSet sprMail = getStatmentBD().executeQuery("SELECT COUNT (nick) FROM gracz where nick = '"+nick+"';");

		if(!sprNick.equals("0"))
			return false;
		else if (!sprMail.equals("0"))
			return false;
		else
			return true;
	}
	
	
	public static boolean czyDaneSaPoprawne(String nick, String mail, String haslo) {

		if(nick.length() > 25 || nick.length() < 4)
			return false;
		else if (mail.length() > 40 || mail.length() < 6)
			return false;
		else if (haslo.length() < 8)
			return false;
		else
			return true;
	}
	
	
	public static void rejestracjaGracza(String nick, String mail, String haslo) throws SQLException {
		
		if (!czyDaneNieSaZajete(nick, mail)) {
			//przekierowanie na kopie strony z info że uzytkownik z takimi danymi juz istnieje
        } else if (!czyDaneSaPoprawne(nick, mail, haslo)) {
			//przekierowanie na kopie strony z info że dane są niepoprane
        } else
            try {
                getStatmentBD().execute("INSERT INTO Gracz (Nick, mail, haslo) VALUES " +
                        "('" + nick + "', '" + mail + "', '" + haslo + "');");
                

            } catch (SQLException e) {
                e.printStackTrace();
            }
	}

}
