package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KontakController {

	
    @GetMapping("/kontakt")
    public String stronaKontaktu() {
        return "kontakt";
    }
}
