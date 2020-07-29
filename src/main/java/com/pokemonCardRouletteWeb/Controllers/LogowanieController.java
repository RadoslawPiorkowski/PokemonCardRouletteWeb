package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogowanieController {

	
    @GetMapping("/logowanie")
    public String stronaLogowania() {
        return "logowanie";
    }
}
