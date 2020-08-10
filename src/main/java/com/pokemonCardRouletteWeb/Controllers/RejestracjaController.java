package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RejestracjaController {


    @GetMapping("/rejestracja")
    public String stronaRejestracji() {
        return "rejestracja";
    }
}
