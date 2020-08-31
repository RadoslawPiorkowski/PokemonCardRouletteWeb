package com.pokemonCardRouletteWeb.Controllers;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class ZmianaHaslaController {


    @GetMapping("/panelGracz")
    public String stronaZmianyHasla(Model model) {
        model.addAttribute("gracz7", new Gracz());
        return "panelGracz";
    }


    @PostMapping(value = "/panelGracz")
    public String zmianaHasla(@ModelAttribute(name = "gracz7") Gracz gracz, Model model) throws SQLException {
        model.addAttribute("gracz7", new Gracz());
        if(gracz.haslo.length() > 2) {
            Gracz.zmianahasla(gracz, GraczZalogowany.id + "");
            return "homeRejestracja";
        } else
            return "rejestracjaError";

    }

}
