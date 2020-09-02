package com.pokemonCardRouletteWeb.Controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pokemonCardRouletteWeb.Data.Gracz;
import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import com.pokemonCardRouletteWeb.Data.Karta;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;
import com.pokemonCardRouletteWeb.Data.Zaklad;


@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry() {
    	
    	if(Zaklad.nagroda == 0) {
    		Zaklad.nowaKartaDoWygrania();
    		Zaklad.nagroda = 1;
    	}
    	
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	PosiadaneKarty.pobierzKartyGraczaZBazyDanych();
    	
        return "gra";
    }
    
    
    @GetMapping("/gra_poczatek")
    public String stronaGra_poczatek(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	model.addAttribute("listaKartZakladu", Zaklad.getListaKartZakladu());
    	model.addAttribute("wygrana", Zaklad.getKartaDoWygrania());
    	model.addAttribute("szansa", Zaklad.getSzansaWygranejText());
        return "gra_poczatek";
    }
	
    
    @GetMapping("/gra_zaklad")
    public String stronaGra_zaklad(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	model.addAttribute("listaKart", PosiadaneKarty.getListaKart());
    	model.addAttribute("kartaZakladu", new Karta());
    	model.addAttribute("szansa", Zaklad.getSzansaWygranejText());

    
        return "gra_zaklad";
    }
    
    
    @PostMapping(value = "/gra_zaklad")
    public String strona_stawka(@ModelAttribute(name = "kartaZakladu") Karta karta, Model model) throws SQLException {

    	if(PosiadaneKarty.czyGraczPosiadaKarte(karta.getNazwa())) {
	    	try {
	        	Zaklad.listaKartZakladu.add(PosiadaneKarty.getKartaPoNazwie(karta.getNazwa()));
	        	PosiadaneKarty.zabierzKarte(karta.getNazwa());
	        	PosiadaneKarty.pobierzKartyGraczaZBazyDanych();
	        	
	        	return "redirect:/gra_poczatek";
	
			} catch (Exception e) {
				return "redirect:/gra_zaklad";
			}
    	} else
    		return "redirect:/gra_zaklad";
    }
    
    
    @GetMapping("/gra_losowanie")
    public String stronaGra_losowanie(Model model) {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
        return "gra_losowanie";
    }
    
}
