package com.pokemonCardRouletteWeb;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pokemonCardRouletteWeb.Data.GraczZalogowany;
import com.pokemonCardRouletteWeb.Data.PosiadaneKarty;

@SpringBootApplication
public class PokemonCardRouletteWebApplication {

	public static void main(String[] args) {

		
		SpringApplication.run(PokemonCardRouletteWebApplication.class, args);

	}

}
