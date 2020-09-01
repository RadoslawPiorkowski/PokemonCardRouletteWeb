package com.pokemonCardRouletteWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;

@Controller
public class ZdobadzKartyController {

	
    @GetMapping("/zdobadzKarty")
    public String stronaGlowna() {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	PosiadaneKarty.pobierzKartyGraczaZBazyDanych();

    	if(PosiadaneKarty.listaKart.size() <= 1)
    		return "pierwszyPakiet";
    	
    	
        return "zakupKart";
    }
    
    
    @GetMapping("/kupionoKarty")
    public String kupiono3(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	PosiadaneKarty.zdobadzKarty(3);
    	model.addAttribute("listaKartNowych", PosiadaneKarty.getListaKartNowych());
    	
        return "kupionoKarty";
    }
    
    @GetMapping("/kupionoKarty7")
    public String kupiono7(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	PosiadaneKarty.zdobadzKarty(7);
    	model.addAttribute("listaKartNowych", PosiadaneKarty.getListaKartNowych());
    	
        return "kupionoKarty7";
    }
    
    @GetMapping("/kupionoKarty10")
    public String kupiono10(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	PosiadaneKarty.zdobadzKarty(10);
    	model.addAttribute("listaKartNowych", PosiadaneKarty.getListaKartNowych());
    	
        return "kupionoKarty10";
    }
}
