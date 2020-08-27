package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Wiadomosc;



@Controller
public class WiadomosciController {

	
    @GetMapping("/wiadomosci")
    public String stronaLogowania(Model model) {
    	
        Wiadomosc.pobierzWiadomosci();
    	model.addAttribute("listaWiadomosci", Wiadomosc.getListaWiadomosci());
    	return "wiadomosci";
    }
}
