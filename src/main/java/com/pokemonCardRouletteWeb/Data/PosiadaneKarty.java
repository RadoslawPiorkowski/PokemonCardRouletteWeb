package com.pokemonCardRouletteWeb.Data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pokemonCardRouletteWeb.BazaDanych;


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
    
    
}
