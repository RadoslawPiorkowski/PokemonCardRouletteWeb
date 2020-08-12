package com.pokemonCardRouletteWeb.Data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pokemonCardRouletteWeb.BazaDanych;


public class PosiadaneKarty{
	
	public static ArrayList<Karta> listaKart = new ArrayList<Karta>();
	
    static {
        try {

            ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Gracz_Karta");

            while (data.next()) 
            	if(data.getInt("gracz_id") == Gracz.id) 
            		listaKart.add(getKartaPoID(data.getInt("karta_id")));
            
        	listaKart.sort(new KartyComparator());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
    
    public static Karta getKartaPoID(int kartaId) throws SQLException {
    	ResultSet data = BazaDanych.getStatmentBD().executeQuery("SELECT * FROM Karta where id_Karta =" + kartaId +"");
    	data.next();
    	
    	return new Karta(kartaId, data.getString("nazwa"), data.getString("rzadkosc"), data.getString("grafika"));
    }



	public static ArrayList<Karta> getListaKart() {
		return listaKart;
	}
    
    
    
}
