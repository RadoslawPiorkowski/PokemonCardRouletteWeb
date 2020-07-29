package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TwojeKartyController {

	
    @GetMapping("/moje_karty")
    public String stronaMoichKart() {
        return "karty";
    }
}
