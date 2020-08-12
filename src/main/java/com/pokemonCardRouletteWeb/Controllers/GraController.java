package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;

@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry() {
    	
    	if(Gracz.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "gra";
    }
	
}
