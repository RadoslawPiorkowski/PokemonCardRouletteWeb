package com.pokemonCardRouletteWeb.Data;

import java.sql.ResultSet;

import com.pokemonCardRouletteWeb.BazaDanych;

public class Generacje {

	public static boolean genOne;
	public static boolean genTwo;
	public static boolean genThree;
	
	static {
		pobierzGeneracje();
	}
	
	public Generacje() {
		
	}
	
	public static boolean isGenOne() {
		return genOne;
	}
	public static void setGenOne(boolean genOne) {
		Generacje.genOne = genOne;
	}
	public static boolean isGenTwo() {
		return genTwo;
	}
	public static void setGenTwo(boolean genTwo) {
		Generacje.genTwo = genTwo;
	}
	public static boolean isGenThree() {
		return genThree;
	}
	public static void setGenThree(boolean genThree) {
		Generacje.genThree = genThree;
	}
	
	public static boolean[] getValues() {
		boolean[] wartosci = new boolean[3];
		
		return wartosci;
	}
	
	public static void pobierzGeneracje() {
		
		try {
			
			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM GENERACJA");
			data.next();
			
			genOne = data.getBoolean("GEN_ONE");
			genTwo = data.getBoolean("GEN_TWO");
			genThree = data.getBoolean("GEN_THREE");
	
			
		} catch (Exception e) {
			e.printStackTrace();
			
			genOne = true;
			genTwo = false;
			genThree = false;
		}
	}

	
	public static void ustawGeneracje(boolean one, boolean two, boolean three) {
		
		try {
			
			BazaDanych.getStatmentBD().execute("UPDATE GENERACJA SET GEN_ONE = " + one + ";");
			BazaDanych.getStatmentBD().execute("UPDATE GENERACJA SET GEN_TWO = " + two + ";");
			BazaDanych.getStatmentBD().execute("UPDATE GENERACJA SET GEN_THREE = " + three + ";");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			genOne = true;
			genTwo = false;
			genThree = false;
		}
	}
	
}

