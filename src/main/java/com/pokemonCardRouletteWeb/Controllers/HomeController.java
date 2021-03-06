package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.GraczZalogowany;

@Controller
public class HomeController {

	
    @GetMapping("/")
    public String stronaStartowa() {
        return "redirect:/home";
    }
	
    @GetMapping("/home")
    public String stronaGlowna() {
        return "home";
    }
	
}
