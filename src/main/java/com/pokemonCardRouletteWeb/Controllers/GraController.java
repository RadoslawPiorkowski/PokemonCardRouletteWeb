package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;


@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry(Model model) {
    	model.addAttribute("gracz", new Gracz());
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "logowanie";
    }
	
}
