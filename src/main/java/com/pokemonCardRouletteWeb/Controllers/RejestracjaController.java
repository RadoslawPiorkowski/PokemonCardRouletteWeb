package com.pokemonCardRouletteWeb.Controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;

@Controller
public class RejestracjaController {


    @GetMapping("/rejestracja")
    public String stronaRejestracji(Model model) {
    	model.addAttribute("gracz", new Gracz());
        return "rejestracja";
    }
    
    
    @PostMapping(value = "/rejestracja")
    public String gracz(@ModelAttribute(name = "gracz") Gracz gracz, Model model) throws SQLException {
    	
    	if(gracz.czyDaneNieSaZajete(gracz) && gracz.czyDaneSaPoprawne(gracz)) {
    		Gracz.rejestracjaGracza(gracz);
    		return "logowanie";
    	} else 
    		return "rejestracjaError";
    	
    }

}

