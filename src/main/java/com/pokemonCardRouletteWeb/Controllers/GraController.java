package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;


@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry(Model model) {
    	model.addAttribute("gracz", new Gracz());
    	
    	if(gracz.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "gra";
    }
	
}
