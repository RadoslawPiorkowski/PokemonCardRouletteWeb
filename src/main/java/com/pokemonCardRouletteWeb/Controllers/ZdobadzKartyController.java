package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;

@Controller
public class ZdobadzKartyController {

	
    @GetMapping("/zdobadzKarty")
    public String stronaGlowna() {
    	
    	if(Gracz.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "zakupKart";
    }
}
