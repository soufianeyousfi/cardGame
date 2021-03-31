package com.atexo.cardgame;

import java.util.Arrays;

public enum Couleur {
	/** Couleur des cartes du paquet: Coeur, Carreau, Treffle, Pique. */
	Coeur(0), Carreau(1), Treffle(2), Pique(3);

	private final int value;

	private Couleur(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static String[] getNames(Class<? extends Enum<?>> e) {
		return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}
}
