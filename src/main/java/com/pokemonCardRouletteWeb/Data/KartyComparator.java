package com.pokemonCardRouletteWeb.Data;

import java.util.Comparator;

public class KartyComparator implements Comparator<Karta> {

	
	@Override
	public int compare(Karta o1, Karta o2) {
		return o1.getId() - o2.getId();
	}
	
	
}
