package com.pokemonCardRouletteWeb.Data;

import com.pokemonCardRouletteWeb.BazaDanych;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Gracz {
	
	public  int id;
	public  String nick;
	public  String mail;
	public  String haslo;
	public	String nazwa;
	
	
	
	public Gracz() {
	}


	public Gracz(int id, String nick, String mail, String haslo) {
		this.id = id;
		this.nick = nick;
		this.mail = mail;
		this.haslo = haslo;
	}

	public Gracz(int id_gracz) {

	}


	public int getId() {
		return id;
	}

	public String getNazwa() {
		return nazwa;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public String getHaslo() {
		return haslo;
	}


	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}


	public boolean czyDaneNieSaZajete(Gracz gracz) throws SQLException {
		ResultSet sprNick = BazaDanych.getStatmentBD().executeQuery("SELECT COUNT (nick) FROM gracz where nick = '"+gracz.nick+"';");
		ResultSet sprMail = BazaDanych.getStatmentBD().executeQuery("SELECT COUNT (mail) FROM gracz where mail = '"+gracz.mail+"';");

		sprNick.next();
		sprMail.next();
		
		if(sprNick.getInt(1) > 0)
			return false;
		else if (sprMail.getInt(1) > 0)
			return false;
		else
			return true;
	}
	
	
	public boolean czyDaneSaPoprawne(Gracz gracz) {

		if(gracz.nick.length() > 25 || gracz.nick.length() < 4)
			return false;
		else if (gracz.mail.length() > 40 || gracz.mail.length() < 6)
			return false;
		else if (gracz.haslo.length() < 2)
			return false;
		else 
			return true;
		
	}
	
	
	public static void rejestracjaGracza(Gracz gracz) throws SQLException {
		
            try {
                BazaDanych.getStatmentBD().execute("INSERT INTO Gracz (Nick, mail, haslo) VALUES " +
                        "('" + gracz.nick + "', '" + gracz.mail + "', '" + gracz.haslo + "');");

            } catch (SQLException e) {
                e.printStackTrace();  
            }
	}

	public static void zmianahasla(Gracz gracz, String id) throws SQLException {

		try {
			BazaDanych.getStatmentBD().execute("UPDATE Gracz SET haslo = '" + gracz.haslo + "'WHERE ID_GRACZ = '" + id + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zmianaReward(String gracz, String karta) throws SQLException {

		try {
			BazaDanych.getStatmentBD().execute("INSERT INTO gracz_karta (gracz_id, karta_id) VALUES (" + PosiadaneKarty.getTrainerIDPoNazwie(gracz) + "," + PosiadaneKarty.getKartaIDPoNazwie(karta) + ");");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zmianaBan(Gracz gracz) throws SQLException {

		try {
			BazaDanych.getStatmentBD().execute("DELETE FROM Gracz WHERE nick = '" + gracz.nick + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void zmianamail(Gracz gracz, String id) throws SQLException {

		try {
			BazaDanych.getStatmentBD().execute("UPDATE Gracz SET mail = '" + gracz.mail + "'WHERE ID_GRACZ = '" + id + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void zmniejszKase(int wartosc) throws SQLException {

		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT kasa FROM gracz where nick = '"+ GraczZalogowany.nick +"';");
			data.next();
			
			int kasa = data.getInt(1) - wartosc;
			
			BazaDanych.getStatmentBD().execute("UPDATE Gracz SET kasa = " + kasa + " WHERE ID_GRACZ = " + GraczZalogowany.id + ";");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean czyStacNaKupno(int wartosc) {

		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT kasa FROM gracz where nick = '"+ GraczZalogowany.nick +"';");
			data.next();
			
			int kasa = data.getInt(1);
			
			if (kasa >= wartosc)
				return true;	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public static int getKasa() {
		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT kasa FROM gracz where nick = '"+ GraczZalogowany.nick +"';");
			data.next();
			
			int kasa = data.getInt(1);
		
			return kasa;	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	public static void zwiekszKase(int wartosc) throws SQLException {

		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT kasa FROM gracz where nick = '"+ GraczZalogowany.nick +"';");
			data.next();
			
			int kasa = data.getInt(1) + wartosc;
			
			BazaDanych.getStatmentBD().execute("UPDATE Gracz SET kasa = " + kasa + " WHERE ID_GRACZ = " + GraczZalogowany.id + ";");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void zwiekszKaseRandom() throws SQLException {

		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT kasa FROM gracz where nick = '"+ GraczZalogowany.nick +"';");
			data.next();
			
			int wartosc = (int) (Math.random() * 5 + 1);
			int kasa = data.getInt(1) + wartosc;
			
			BazaDanych.getStatmentBD().execute("UPDATE Gracz SET kasa = " + kasa + " WHERE ID_GRACZ = " + GraczZalogowany.id + ";");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateDate() {

		Date dzis = new Date();
		
        try {
            BazaDanych.getStatmentBD().execute("UPDATE GRACZ SET free='" + dzis + "' WHERE nick ='" + GraczZalogowany.nick + "';");  
            GraczZalogowany.dataFree = dzis;
            GraczZalogowany.czyOdebranoFreeKarte();
            
        } catch (SQLException e) {
            e.printStackTrace();  
        }
	}

	
	public boolean czyGraczIstniejeWBazie(Gracz gracz) throws SQLException {
		ResultSet sprNick = BazaDanych.getStatmentBD().executeQuery("SELECT COUNT (nick) FROM gracz where nick = '"+gracz.nick+"';");

		sprNick.next();
		
		if(sprNick.getInt(1) != 1)
			return false;
		else
			return true;
	}
	
	public boolean czyHasloJestPoprawne(Gracz gracz) throws SQLException {
        ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT haslo FROM gracz where nick = '"+gracz.nick+"';");

		data.next();
		
		if(!data.getString(1).equals(gracz.haslo))
			return false;
		else
			return true;
	}
}
