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
public class ZmianaEmailController {


    @GetMapping("/panelGraczEmail")
    public String stronaZmianyEmail(Model model) {
        model.addAttribute("gracz8", new Gracz());
        return "panelGraczEmail";
    }

    @PostMapping(value = "/panelGraczEmail")
    public String stronaZmianyEmail(@ModelAttribute(name = "gracz8") Gracz gracz, Model model) throws SQLException {
        model.addAttribute("gracz8", new Gracz());
        if(gracz.mail.length() > 5) {
            Gracz.zmianamail(gracz, GraczZalogowany.id + "");
            return "panelGraczEmailSuccess";
        } else
            return "panelGraczEmailFail";

    }




//    @PostMapping(value = "/panelGracz")
//    public String zmianaHasla(@ModelAttribute(name = "gracz7") Gracz gracz, Model model) throws SQLException {
//        model.addAttribute("gracz7", new Gracz());
//        if(gracz.haslo.length() > 2) {
//            Gracz.zmianahasla(gracz, GraczZalogowany.id + "");
//            return "/homeZmianaHasla";
//        } else
//            return "/homeZmianaHaslaError";
//
//    }


}

