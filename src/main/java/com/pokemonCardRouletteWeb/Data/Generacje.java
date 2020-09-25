package com.pokemonCardRouletteWeb.Data;

import java.sql.ResultSet;

import com.pokemonCardRouletteWeb.BazaDanych;

public class Generacje {

	public boolean genOne;
	public boolean genTwo;
	public boolean genThree;
	

	public Generacje() {
		
	}
	

	
	public boolean isGenOne() {
		return genOne;
	}

	public void setGenOne(boolean genOne) {
		this.genOne = genOne;
	}

	public boolean isGenTwo() {
		return genTwo;
	}

	public void setGenTwo(boolean genTwo) {
		this.genTwo = genTwo;
	}


	public boolean isGenThree() {
		return genThree;
	}

	public void setGenThree(boolean genThree) {
		this.genThree = genThree;
	}

	
	
//	public static void pobierzGeneracje() {
//		
//		try {
//			
//			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM GENERACJA;");
//			data.next();
//			
//			genOne = data.getBoolean("GEN_ONE");
//			genTwo = data.getBoolean("GEN_TWO");
//			genThree = data.getBoolean("GEN_THREE");
//	
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//	}

	public static boolean pobierzGenOne() {
		
		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM GENERACJA;");
			data.next();
			
			return data.getBoolean("GEN_ONE");
	
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean pobierzGenTwo() {
		
		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM GENERACJA;");
			data.next();
			
			return data.getBoolean("GEN_TWO");
	
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean pobierzGenThree() {
		
		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM GENERACJA;");
			data.next();
			
			return data.getBoolean("GEN_THREE");
	
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static void ustawGeneracje(Generacje generacje) {
		
		try {
			
			BazaDanych.getStatmentBD().execute("UPDATE GENERACJA SET GEN_ONE = " + generacje.isGenOne() + ";");
			BazaDanych.getStatmentBD().execute("UPDATE GENERACJA SET GEN_TWO = " + generacje.isGenTwo() + ";");
			BazaDanych.getStatmentBD().execute("UPDATE GENERACJA SET GEN_THREE = " + generacje.isGenThree() + ";");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

