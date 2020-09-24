package com.pokemonCardRouletteWeb.Controllers;


import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pokemonCardRouletteWeb.Data.Generacje;
import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;

@Controller
public class ZmianaGeneracjiController {

    @GetMapping("/panelAdminGen")
    public String stronaZmianyGeneracji(Model model) {
        
    	if(GraczZalogowany.id == 1){
    		model.addAttribute("generacje", Generacje.getValues());
    		return "panelAdminGen";
        } else
            return "home";
    	
    }

    @PostMapping(value = "/panelAdminGen")
    public String stronaZmianyGeneracji(@ModelAttribute(name = "generacje") Gracz gracz, Model model) throws SQLException {
        
    	if(GraczZalogowany.id == 1){
    		
    		
    		return "panelAdminGenSuccess";
        } else
            return "home";

    }

	
}
