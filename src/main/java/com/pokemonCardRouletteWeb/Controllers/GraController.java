package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry() {
        return "gra";
    }
	
	

}
