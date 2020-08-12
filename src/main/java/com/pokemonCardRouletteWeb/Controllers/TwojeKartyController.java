package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;


@Controller
public class TwojeKartyController {

	
    @GetMapping("/karty")
    public String stronaMoichKart(Model model) {
    	
    	if(Gracz.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	model.addAttribute("listaKart", PosiadaneKarty.getListaKart());
        return "karty";
    }
    
  
}
