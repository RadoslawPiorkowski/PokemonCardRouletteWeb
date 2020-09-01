package com.pokemonCardRouletteWeb.Controllers;

import com.pokemonCardRouletteWeb.Data.Gracz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class ZmianaBanController {


    @GetMapping("/panelAdminBan")
    public String stronaZmianyEmail(Model model) {
        model.addAttribute("gracz9", new Gracz());
        return "panelAdminBan";
    }

    @PostMapping(value = "/panelAdminBan")
    public String stronaZmianyEmail(@ModelAttribute(name = "gracz9") Gracz gracz, Model model) throws SQLException {
        model.addAttribute("gracz9", new Gracz());
        if(gracz.nick.length() > 2) {
            Gracz.zmianaBan(gracz);
            return "panelAdminBanSuccess";
        } else
            return "panelAdminBanFail";

    }

}

