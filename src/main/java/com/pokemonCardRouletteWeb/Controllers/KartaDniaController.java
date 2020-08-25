package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;

@Controller
public class KartaDniaController {

	
    @GetMapping("/kartaDnia")
    public String stronaKartyDnia() {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "kartaDnia";
    }
	
}
