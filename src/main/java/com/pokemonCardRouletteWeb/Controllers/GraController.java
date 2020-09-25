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
import com.pokemonCardRouletteWeb.Data.Karta;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;
import com.pokemonCardRouletteWeb.Data.Zaklad;


@Controller
public class GraController {

	
	
    @GetMapping("/gra")
    public String stronaGry() {
    	
    	if(Zaklad.nagroda == 0) {
    		Zaklad.wyczyscZaklad();
    		Zaklad.nowaKartaDoWygrania();
    		Zaklad.nagroda = 1;
    		Zaklad.aktualizujSzanseWygranej();
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
    
    
    @PostMapping("/gra_losowanie")
    public String stronaGra_wylosowane(Model model) {
    	
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    
        return "gra_losowanie";
    }
    
    @GetMapping("/gra_wynik")
    public String stronaGra_wygrana(Model model) throws SQLException {
    	
    	if(GraczZalogowany.nick.equals(""))
    		return "redirect:/logowanie";
    	
    	Zaklad.wylosujZwyciezkiNumer();
    	model.addAttribute("wylosowanyNumer", Zaklad.getZwyciezkiNumerText());
    	model.addAttribute("wygrana", Zaklad.getKartaDoWygraniaText());
    	model.addAttribute("wynik", Zaklad.getSzansaWygranejText2());
    	
    	if(Zaklad.getZwyciezkiNumer() <= Zaklad.getSzansaWygranej()) {
				Gracz.zwiekszKaseRandom();
	    		Zaklad.nagroda = 0;
	    		Zaklad.przydzielWygrana();
	            return "gra_wygrana";
    	} else {
    		Zaklad.nagroda = 0;
        	return "gra_przegrana";
    	}
    }

    
}
