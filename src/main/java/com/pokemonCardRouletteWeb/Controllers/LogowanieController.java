package com.pokemonCardRouletteWeb.Controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;

@Controller
public class LogowanieController {


    
    @GetMapping("/logowanie")
    public String stronaLogowania(Model model) {
    	model.addAttribute("graczZalogowany", new Gracz());
        return "logowanie";
    }
    
    
    @PostMapping(value = "/logowanie")
    public String graczZalogowany(@ModelAttribute(name = "graczZalogowany") Gracz gracz, Model model) throws SQLException {
    	
    	if(gracz.czyGraczIstniejeWBazie(gracz) && gracz.czyHasloJestPoprawne(gracz)) {
    		GraczZalogowany.zaloguj(gracz);
    		PosiadaneKarty.pobierzKartyGraczaZBazyDanych();
    		return "home";
    	} else 
    		return "logowanie";
    	
    }
}
