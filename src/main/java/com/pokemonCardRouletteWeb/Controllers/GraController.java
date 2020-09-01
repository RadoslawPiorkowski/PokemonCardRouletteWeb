package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import com.pokemonCardRouletteWeb.Data.Zaklad;


@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry() {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "gra";
    }
    
    
    @GetMapping("/gra_poczatek")
    public String stronaGra_poczatek(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	model.addAttribute("wygrana", Zaklad.getKartaDoWygrania());
        return "gra_poczatek";
    }
	
}
