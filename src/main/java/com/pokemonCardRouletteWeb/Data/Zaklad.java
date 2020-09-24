package com.pokemonCardRouletteWeb.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pokemonCardRouletteWeb.BazaDanych;

public class Zaklad {
	
	public static int nagroda = 0;
	public static Karta kartaDoWygrania ;
	public static int szansaWygranej = 0;
	public static String kartaZakladu = "";
	public static int zwyciezkiNumer;

	
	public static ArrayList<Karta> listaKartZakladu = new ArrayList<Karta>();
	

	
	
	public static int getZwyciezkiNumer() {
		return zwyciezkiNumer;
	}

	public static String getKartaZakladu() {
		return kartaZakladu;
	}

	public static Karta getKartaDoWygrania() {
		return kartaDoWygrania;
	}


	public static int getSzansaWygranej() {
		return szansaWygranej;
	}

	public static String getSzansaWygranejText() {
		return "Your winning rate is " + szansaWygranej + " to 36";
	}

	public static String getSzansaWygranejText2() {
		return "Your winning rate was " + szansaWygranej + " to 36";
	}
	
	public static ArrayList<Karta> getListaKartZakladu() {
		return listaKartZakladu;
	}

	
	public static void wylosujZwyciezkiNumer() {
		int randomNumer =(int) (Math.random() * 36);
		
		zwyciezkiNumer = randomNumer;
	}

	public static void nowaKartaDoWygrania() {
		int randomCard = PosiadaneKarty.numerKartyZGeneracji();
		
		try {
			kartaDoWygrania = PosiadaneKarty.getKartaPoID(randomCard);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void dodajKarteDoZakladu(String nazwa) {
		
		if(czyGraczPosiadaKarte(nazwa)) {
			try {
				listaKartZakladu.add(PosiadaneKarty.getKartaPoNazwie(nazwa));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static boolean czyGraczPosiadaKarte(String nazwa) {
		Karta karta = null;
		try {
			karta = PosiadaneKarty.getKartaPoNazwie(nazwa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(PosiadaneKarty.listaKart.contains(karta)) 
			return true;
		else
			return false;
	
	}
	
	public static void aktualizujSzanseWygranej() {

		if(obliczSzanseWygranej() > 30)
			szansaWygranej = 30;
		else
			szansaWygranej = obliczSzanseWygranej();
	}
	
	
	private static int obliczSzanseWygranej() {
		double szansa = 0;
		double silaKasyna = 0;
		double silaKart = 0;
		
		if(kartaDoWygrania.getRzadkosc().equals("common"))
			silaKasyna += 2;
		else if(kartaDoWygrania.getRzadkosc().equals("uncommon"))
			silaKasyna += 4;
		else if(kartaDoWygrania.getRzadkosc().equals("rare"))
			silaKasyna += 6;
		else if(kartaDoWygrania.getRzadkosc().equals("legendary"))
			silaKasyna += 8;
		else
			silaKasyna += 10;
		
		
		for (Karta karta : listaKartZakladu) {
			String rzadkosc = karta.getRzadkosc();
			if(rzadkosc.equals("common"))
				silaKart += 2;
			else if(rzadkosc.equals("uncommon"))
				silaKart += 4;
			else if(rzadkosc.equals("rare"))
				silaKart += 6;
			else if(rzadkosc.equals("legendary"))
				silaKart += 8;
			else
				silaKart += 10;
		}
		
		szansa = ( 36 /(silaKasyna + silaKart))  * silaKart;
		
		return (int) szansa;
	}
	
	
    
	public static void przydzielWygrana() {
		
		
		try {
			
			for(Karta karta: listaKartZakladu) {
				
              BazaDanych.getStatmentBD().execute("INSERT INTO gracz_karta (gracz_id, karta_id) VALUES " +
              "('" + GraczZalogowany.id + "', '" + karta.getId() + "');");
			}
			
			BazaDanych.getStatmentBD().execute("INSERT INTO gracz_karta (gracz_id, karta_id) VALUES " +
		              "('" + GraczZalogowany.id + "', '" + kartaDoWygrania.getId() + "');");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void wyczyscZaklad() {
		listaKartZakladu.clear();
	}

	public static String getZwyciezkiNumerText() {
		return "The number drawn is " + zwyciezkiNumer;
	}

	public static String getKartaDoWygraniaText() {
		return "So you won - " + kartaDoWygrania.getNazwa() + "!!! Maybe one more round?";
	}
	
	
}
