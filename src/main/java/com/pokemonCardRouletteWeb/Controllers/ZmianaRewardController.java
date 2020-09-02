package com.pokemonCardRouletteWeb.Controllers;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.Karta;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;
import com.pokemonCardRouletteWeb.Data.Zaklad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class ZmianaRewardController {


    @GetMapping("/panelAdminReward")
    public String stronaZmianyReward(Model model) {
        PosiadaneKarty.pobierzWszystkieKartyZBazyDanych();
        model.addAttribute("listaKartZakladu", Zaklad.getListaKartZakladu());
        model.addAttribute("listaKart", PosiadaneKarty.getListaKart());
        model.addAttribute("kartaZakladu", new Karta());
        model.addAttribute("gracz10", new Gracz());

        return "panelAdminReward";
    }

    @PostMapping(value = "/panelAdminReward")
    public String stronaZmianyReward(@ModelAttribute(name = "gracz10") Gracz gracz, Model model) throws SQLException {
        model.addAttribute("gracz10", new Gracz());
        if(gracz.nick.length() > 2) {
            Gracz.zmianaBan(gracz);
            return "panelAdminBanSuccess";
        } else
            return "panelAdminBanFail";

    }

}

