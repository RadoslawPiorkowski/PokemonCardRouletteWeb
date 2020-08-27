package com.pokemonCardRouletteWeb.Controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pokemonCardRouletteWeb.BazaDanych;
import com.pokemonCardRouletteWeb.Data.Wiadomosc;

@Controller
public class KontakController {

	
    @GetMapping("/kontakt")
    public String stronaKontaktu(Model model) {
    	model.addAttribute("wiadomosc", new Wiadomosc());
        return "kontakt";
    }
    
    
    @PostMapping("/kontakt")
    public String getWiadomosc(@ModelAttribute Wiadomosc wiadomosc) {
    	
		if(!wiadomosc.getName().isEmpty() && !wiadomosc.getMail().isEmpty() && !wiadomosc.getSubject().isEmpty() && !wiadomosc.getText().isEmpty() && !wiadomosc.getNumber().isEmpty()) {
			Wiadomosc.listaWiadomosci.add(wiadomosc);
			 try {
				 BazaDanych.getStatmentBD().execute("INSERT INTO wiadomosc (imie, mail, numer, temat, tekst) VALUES "+ "('" + wiadomosc.getName() + "' , '" + wiadomosc.getMail() + "' , '" + wiadomosc.getNumber() + "' , '" + wiadomosc.getSubject() + "' , '" + wiadomosc.getText() + "');");
             } catch (SQLException e) {
                 e.printStackTrace();
             }
		
			return "wyslanoWiadomosc";
		}
		
		return "home";
    }
}
