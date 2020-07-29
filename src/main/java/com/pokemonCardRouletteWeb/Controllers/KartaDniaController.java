package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KartaDniaController {

	
    @GetMapping("/karta_dnia")
    public String stronaKartyDnia() {
        return "kartaDnia";
    }
	
}
