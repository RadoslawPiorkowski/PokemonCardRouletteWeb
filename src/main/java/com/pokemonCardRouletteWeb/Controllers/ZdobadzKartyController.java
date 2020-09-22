package com.pokemonCardRouletteWeb.Controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;

@Controller
public class ZdobadzKartyController {

	
    @GetMapping("/zdobadzKarty")
    public String stronaGlowna(Model model) throws SQLException {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	model.addAttribute("kasa", Gracz.getKasa());
    	PosiadaneKarty.pobierzKartyGraczaZBazyDanych();

    	if(PosiadaneKarty.listaKart.size() <= 1) {
    		Gracz.zwiekszKase(25);
    		return "pierwszyPakiet";
    	}

        return "zakupKart";
    }
    

    
    @GetMapping("/kupionoKarty")
    public String kupiono3(Model model) throws SQLException {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	if(Gracz.czyStacNaKupno(5)) {
        	Gracz.zmniejszKase(5);
        	PosiadaneKarty.zdobadzKarty(3);
        	model.addAttribute("listaKartNowych", PosiadaneKarty.getListaKartNowych());
        	
            return "kupionoKarty";
    	} else {
        	model.addAttribute("kasa", Gracz.getKasa());
			return "zakupKartError";
		}

    }
    
    @GetMapping("/kupionoKarty7")
    public String kupiono7(Model model) throws SQLException {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	if(Gracz.czyStacNaKupno(25)) {
        	Gracz.zmniejszKase(25);
        	PosiadaneKarty.zdobadzKarty(7);
        	model.addAttribute("listaKartNowych", PosiadaneKarty.getListaKartNowych());
        	
            return "kupionoKarty7";
    	} else {
        	model.addAttribute("kasa", Gracz.getKasa());
    	    return "zakupKartError";
		}
    	
    }
    
    
    @GetMapping("/kupionoKarty10")
    public String kupiono10(Model model) throws SQLException {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	if(Gracz.czyStacNaKupno(35)) {
        	Gracz.zmniejszKase(35);
        	PosiadaneKarty.zdobadzKarty(10);
        	model.addAttribute("listaKartNowych", PosiadaneKarty.getListaKartNowych());
        	
            return "kupionoKarty10";
    	} else 
        	model.addAttribute("kasa", Gracz.getKasa());
    		return "zakupKartError";
    }
}
