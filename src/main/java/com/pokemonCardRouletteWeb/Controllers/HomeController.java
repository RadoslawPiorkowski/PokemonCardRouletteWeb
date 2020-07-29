package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
