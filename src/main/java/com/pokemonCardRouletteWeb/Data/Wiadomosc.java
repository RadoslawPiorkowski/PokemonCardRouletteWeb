package com.pokemonCardRouletteWeb.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pokemonCardRouletteWeb.BazaDanych;


public class Wiadomosc {
	
	public String name;
	public String mail;
	public String number;
	public String subject;
	public String text;
	
	public static ArrayList<Wiadomosc> listaWiadomosci = new ArrayList<Wiadomosc>();
	
    static {
        try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM wiadomosc");

            while (data.next())
            	listaWiadomosci.add(new Wiadomosc(data.getString("Imie"), data.getString("mail"), data.getString("numer"), data.getString("temat"), data.getString("tekst")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	
	public Wiadomosc() {
	}


	public Wiadomosc(String name, String mail, String number, String subject, String text) {
		super();
		this.name = name;
		this.mail = mail;
		this.number = number;
		this.subject = subject;
		this.text = text;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	

	public static ArrayList<Wiadomosc> getListaWiadomosci() {
		return listaWiadomosci;
	}
	
	public static void pobierzWiadomosci() {
		wyczyscListeWiadomosci();
        try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM wiadomosc");

            while (data.next())
            	listaWiadomosci.add(new Wiadomosc(data.getString("Imie"), data.getString("mail"), data.getString("numer"), data.getString("temat"), data.getString("tekst")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public static void wyczyscListeWiadomosci() {
		listaWiadomosci.clear();
	}

	
	@Override
	public String toString() {
		return "Message from: "+ name +
				"\nMail: " + mail + 
				"\nNumber: " + number + 
				"\nSubject:" + subject + 
				"\n"+ text + 
				"\n\n";
	}


	
	
	
}
