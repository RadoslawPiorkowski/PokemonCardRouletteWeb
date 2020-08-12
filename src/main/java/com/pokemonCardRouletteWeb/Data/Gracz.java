package com.pokemonCardRouletteWeb.Data;

public class Gracz {
	
	public static int id = 2;
	public static String nick = "Ash";
	public static String mail;
	
	
	public Gracz(int id, String nick, String mail) {
		Gracz.id = id;
		Gracz.nick = nick;
		Gracz.mail = mail;
	}


	public int getId() {
		return id;
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
	
	
	

}
