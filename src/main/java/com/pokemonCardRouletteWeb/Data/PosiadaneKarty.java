package com.pokemonCardRouletteWeb.Data;


import com.pokemonCardRouletteWeb.BazaDanych;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PosiadaneKarty{
	

	public static ArrayList<Karta> listaKart = new ArrayList<Karta>();
	public static ArrayList<Karta> listaKartNowych = new ArrayList<Karta>();


	
    
    public static Karta getKartaPoID(int kartaId) throws SQLException {
    	ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Karta where id_Karta =" + kartaId +"");
    	data.next();
    	
    	return new Karta(kartaId, data.getString("nazwa"), data.getString("rzadkosc"), data.getString("grafika"));
    }

	
    public static Karta getKartaPoNazwie(String nazwa) throws SQLException {
    	ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Karta where nazwa ='" + nazwa +"'");
    	data.next();
    	
    	return new Karta(data.getInt("id_Karta"), data.getString("nazwa"), data.getString("rzadkosc"), data.getString("grafika"));
    }


    public static void zabierzKarte(String nazwa) {
    	
    	try {
			int idKarty = getKartaPoNazwie(nazwa).getId();
			
			 BazaDanych.getStatmentBD().execute("DELETE FROM gracz_karta WHERE id_gracz_karta IN (SELECT id_gracz_karta FROM gracz_karta WHERE gracz_id = "+ GraczZalogowany.id +" and karta_id =" + idKarty + " LIMIT 1);");
			 Zaklad.aktualizujSzanseWygranej();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
    public static boolean czyGraczPosiadaKarte(String nazwa) {
    	
    	for (Karta karta : listaKart) {
			if (karta.getNazwa().equals(nazwa))
				return true;
		}
    	
    	return false;
    }

    
    
	public static int getKartaIDPoNazwie(String nazwa) throws SQLException {
		ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Karta where nazwa ='" + nazwa +"'");
		data.next();
		//data.next();
		//Karta id_karta = new Karta(data.getInt("id_Karta"));
		return data.getInt("id_Karta");

	}

	public static int getTrainerIDPoNazwie(String nick) throws SQLException {
		ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Gracz where nick ='" + nick +"'");
		data.next();

		Gracz id_gracz = new Gracz(data.getInt("id_gracz"));
		return id_gracz.getId();
	}

    
	public static void pobierzKartyGraczaZBazyDanych() {

		wyczyscListeKart();
		
		try {

            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Gracz_Karta");
            
            while (data.next()) 
            	if(data.getInt("gracz_id") == GraczZalogowany.id) 
            		listaKart.add(getKartaPoID(data.getInt("karta_id")));
            
        	listaKart.sort(new KartyComparator());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public static void pobierzWszystkieKartyZBazyDanych(){

		wyczyscListeKart();

		try {

			ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Karta");

			while (data.next())
					listaKart.add(getKartaPoID(data.getInt("ID_KARTA")));
			listaKart.sort(new KartyComparator());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static void zdobadzKarty(int ilosc) {

		wyczyscListeKartNowych();
		
		try {
            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT COUNT (karta) FROM Karta");
            data.next();
            
            int liczbaKart = data.getInt("count") - 1;
            
            for(int i = 0; i < ilosc; i++) {
            	
            	int losowaKarta = (int)( Math.random() * liczbaKart) + 1;
            	
                BazaDanych.getStatmentBD().execute("INSERT INTO gracz_karta (gracz_id, karta_id) VALUES " +
                        "('" + GraczZalogowany.id + "', '" + losowaKarta + "');");
                
                listaKartNowych.add(getKartaPoID(losowaKarta));
            
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    

	
	public static void wyczyscListeKart() {
		listaKart.clear();
	}
    
	public static void wyczyscListeKartNowych() {
		listaKartNowych.clear();
	}


	
	public static ArrayList<Karta> getListaKart() {
		return listaKart;
	}
	

	public static ArrayList<Karta> getListaKartNowych() {
		return listaKartNowych;
	}


	static class getString extends Karta {
		public String nick;

		public getString(String id_karta) {
		}
	}

	private static class getIntiger {
	}
}
