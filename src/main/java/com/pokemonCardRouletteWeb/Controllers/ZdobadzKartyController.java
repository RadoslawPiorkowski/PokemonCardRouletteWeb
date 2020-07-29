package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZdobadzKartyController {

	
    @GetMapping("/zdobadz_karty")
    public String stronaGlowna() {
        return "zakupKart";
    }
}
