package com.pokemonCardRouletteWeb.Data;

import java.sql.ResultSet;

import com.pokemonCardRouletteWeb.BazaDanych;

public class GraczZalogowany {

	public static int id = 2;
	public static String nick = "";
	public static String mail = "";
	public static String haslo = "";
	
	
	
	public static void zaloguj(Gracz gracz) {
		GraczZalogowany.nick = gracz.nick;
		GraczZalogowany.haslo = gracz.haslo;
		GraczZalogowany.id = getIdFromDB(gracz);
		GraczZalogowany.mail = getMailFromDB(gracz);
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
	
	public static int getIdFromDB(Gracz gracz) {
		
		try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT id_gracz FROM gracz where nick = '"+gracz.nick+"';");
            
            data.next();
            int id = data.getInt(1);
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	public static String getMailFromDB(Gracz gracz) {
		try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT mail FROM gracz where nick = '"+gracz.nick+"';");
            
            data.next();
            String mail = data.getString(1);
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mail;
	}
	
	public static void clearGraczZalogowany() {
		id = 0;
		nick = "";
		mail = "";
		haslo = "";
	}

}
