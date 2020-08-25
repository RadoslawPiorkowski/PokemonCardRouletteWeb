package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;

@Controller
public class ZdobadzKartyController {

	
    @GetMapping("/zdobadzKarty")
    public String stronaGlowna() {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "zakupKart";
    }
}
