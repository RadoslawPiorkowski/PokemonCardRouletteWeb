package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZasadyController {

	
    @GetMapping("/zasady")
    public String stronaZasad() {
        return "zasady";
    }
    
}
