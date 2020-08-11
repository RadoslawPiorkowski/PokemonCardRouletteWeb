package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;


@Controller
public class TwojeKartyController {

	
    @GetMapping("/karty")
    public String stronaMoichKart(Model model) {
    	model.addAttribute("listaKart", PosiadaneKarty.getListaKart());
        return "karty";
    }
    
  
}
