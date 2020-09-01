package com.pokemonCardRouletteWeb.Data;

import java.sql.SQLException;
import java.util.ArrayList;

public class Zaklad {
	
	public static Karta kartaDoWygrania;
	public static int szansaWygranej = 0;
	
	public static ArrayList<Karta> listaKartZakladu = new ArrayList<Karta>();
	
	static {
		nowaKartaDoWygrania();
	}

	
	
	public static Karta getKartaDoWygrania() {
		return kartaDoWygrania;
	}


	public static int getSzansaWygranej() {
		return szansaWygranej;
	}


	public static ArrayList<Karta> getListaKartZakladu() {
		return listaKartZakladu;
	}


	public static void nowaKartaDoWygrania() {
		int randomCard =(int) (Math.random() * 150 +1);
		
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
		szansaWygranej = 0;

		if(obliczSzanseWygranej() > 30)
			szansaWygranej = 30;
		else
			szansaWygranej = obliczSzanseWygranej();
	}
	
	
	private static int obliczSzanseWygranej() {
		int szansa = 0;
		int silaKasyna = 0;
		int silaKart = 0;
		
		if(kartaDoWygrania.getRzadkosc().equals("common"))
			silaKasyna += 2;
		else if(kartaDoWygrania.getRzadkosc().equals("uncommon"))
			silaKasyna += 4;
		else if(kartaDoWygrania.getRzadkosc().equals("rare"))
			silaKasyna += 8;
		else if(kartaDoWygrania.getRzadkosc().equals("legendary"))
			silaKasyna += 6;
		else
			silaKasyna += 10;
		
		for (Karta karta : listaKartZakladu) {
			String rzadkosc = karta.getRzadkosc();
			if(rzadkosc.equals("common"))
				silaKart += 2;
			else if(rzadkosc.equals("uncommon"))
				silaKart += 4;
			else if(rzadkosc.equals("rare"))
				silaKart += 8;
			else if(rzadkosc.equals("legendary"))
				silaKart += 6;
			else
				silaKart += 10;
		}
		
		szansa = ((silaKasyna + silaKart) / 36) * silaKart;
		
		return szansa;
	}
	
	
	public static void wyczyscZaklad() {
		listaKartZakladu.clear();
	}
	
	
}
