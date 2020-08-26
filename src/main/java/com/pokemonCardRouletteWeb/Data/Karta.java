package com.pokemonCardRouletteWeb.Data;

import java.io.Serializable;
import java.sql.SQLException;

import com.pokemonCardRouletteWeb.BazaDanych;

public class Karta implements Serializable {

	int id;
	String nazwa;
	String rzadkosc;
	String grafika;
	
	
	public Karta(int id, String nazwa, String rzadkosc, String grafika) {
		this.id = id;
		this.nazwa = nazwa;
		this.rzadkosc = rzadkosc;
		this.grafika = grafika;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNazwa() {
		return nazwa;
	}


	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}


	public String getRzadkosc() {
		return rzadkosc;
	}


	public void setRzadkosc(String rzadkosc) {
		this.rzadkosc = rzadkosc;
	}


	public String getGrafika() {
		return grafika;
	}


	public void setGrafika(String grafika) {
		this.grafika = grafika;
	}


	@Override
	public String toString() {
		return "Karta: id = " + id + ", nazwa=" + nazwa + ", rzadkosc=" + rzadkosc;
	}
	
	
	
}
