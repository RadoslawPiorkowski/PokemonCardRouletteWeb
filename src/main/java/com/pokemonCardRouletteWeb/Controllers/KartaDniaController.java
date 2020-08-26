package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;

@Controller
public class KartaDniaController {

	
    @GetMapping("/kartaDnia")
    public String stronaKartyDnia() {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	if(GraczZalogowany.czyOdebrano == false)
    		return "kartaDnia";
    	else
    		return "kartaDniaOczekiwanie";
    }

    @GetMapping("/otrzymanaKarta")
    public String otrzymano(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	PosiadaneKarty.zdobadzKarty(1);
    	Gracz.updateDate();
    	model.addAttribute("listaKartNowych", PosiadaneKarty.getListaKartNowych());
    	
        return "otrzymanaKarta";
    }
    
}
