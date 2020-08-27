package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.GraczZalogowany;


@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry() {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "gra";
    }
	
}
