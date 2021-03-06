package com.pokemonCardRouletteWeb.Data;

import com.pokemonCardRouletteWeb.BazaDanych;

import java.sql.ResultSet;
import java.util.Date;

public class GraczZalogowany {

	public static int id = 0;
	public static String nick = "";
	public static String mail = "";
	public static String haslo = "";
	public static Date dataFree;
	public static boolean czyOdebrano;
	
	public static void zaloguj(Gracz gracz) {
		GraczZalogowany.nick = gracz.nick;
		GraczZalogowany.id = getIdFromDB(gracz.nick);
		GraczZalogowany.mail = getMailFromDB(gracz.nick);
		GraczZalogowany.dataFree = getFreeFromDB(nick);
		czyOdebranoFreeKarte();
	}

	public static int getId() {
		return id;
	}
	
	public static void setId(int id) {
		GraczZalogowany.id = id;
	}
	
	public static String getNick() {
		return nick;
	}
	
	public static void setNick(String nick) {
		GraczZalogowany.nick = nick;
	}
	
	public static String getMail() {
		return mail;
	}
	
	public static void setMail(String mail) {
		GraczZalogowany.mail = mail;
	}
	
	public static String getHaslo() {
		return haslo;
	}
	
	public static void setHaslo(String haslo) {
		GraczZalogowany.haslo = haslo;
	}
	
	public static int getIdFromDB(String nick) {
		
		try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM gracz where nick = '"+nick+"';");
            
            data.next();
            int id = data.getInt("id_gracz");
    		return id;
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;

	}
	
	
	public static String getMailFromDB(String nick) {
		try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM gracz where nick = '" + nick + "';");
            
            data.next();
            String mail = data.getString("mail");
    		return mail;
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	public static Date getFreeFromDB(String nick) {
		try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM gracz where nick = '"+nick+"';");
            
            data.next();
            Date mail = data.getDate("free");
    		return mail;
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Date();
	}
	
	
	@SuppressWarnings("deprecation")
	public static void czyOdebranoFreeKarte() {
		Date dzis = new Date();
		Date ostatnio = dataFree;
		
		if(dzis.getDay() == ostatnio.getDay()) 
			czyOdebrano = true;
		else
			czyOdebrano = false;	
	}
	
	
	
	
	public static boolean getCzyOdebrano() {
		return czyOdebrano;
	}




	public static void setCzyOdebrano(boolean czyOdebrano) {
		GraczZalogowany.czyOdebrano = czyOdebrano;
	}




	public static void clearGraczZalogowany() {
		id = 0;
		nick = "";
		mail = "";
		haslo = "";
	}

}
