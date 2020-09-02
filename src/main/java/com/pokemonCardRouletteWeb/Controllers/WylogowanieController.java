package com.pokemonCardRouletteWeb.Controllers;

import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WylogowanieController {

    @GetMapping("/homeWyloguj")
    public String stronaWylogowania(Model model) {
        GraczZalogowany.clearGraczZalogowany();
        return "homeWyloguj";
    }

}
