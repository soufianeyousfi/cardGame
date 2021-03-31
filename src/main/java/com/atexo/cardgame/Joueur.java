package com.atexo.cardgame;

import java.util.Arrays;

/**
 * <p>
 * Cette classe mod�lise un joueur.
 * </p>
 * 
 * @author Soufiane YOUSFI.
 */
public class Joueur {

	/**
	 * La main du joueur ( son paquet des cartes )
	 */
	JeuDeCarte hand;

	/**
	 * Le nom du joueur
	 */
	private String nom;
	private boolean isSorting;


	/**
	 * Constructeur avec nom
	 * 
	 * @param n
	 *            le nom du joueur
	 */
	public Joueur(String n) {
		hand = new JeuDeCarte();
		this.nom = n;

	}

	/**
	 * ajouter une carte a sa main
	 */
	public void ajoute(Carte[] card) {
	      Arrays.stream(card)
          .forEach(c->hand.ajoute(c));
	      isSorting = Boolean.FALSE;
	}

	public void refresh(Carte[] c) {

		hand.refresh(c);
		isSorting = Boolean.TRUE;

	}

	/** Combien de cartes a le joueur */
	public int combienDeCartes() {
		return hand.getNb_Carte();
	}

	/**
	 * Donne une description du joueur .
	 * 
	 * @return la description d'un joueur.
	 */
	public String toString() {
		String action = !isSorting
				? Constantes.NEW_LINE + "Joueur : " + nom + " | Main : " + hand.getNb_Carte() + " cartes"
						+ Constantes.DOUBLE_NEW_LINE + Constantes.UNDERLINE + "[ Distribuer et mélanger les cartes ]"
						+ Constantes.UNDERLINE + Constantes.DOUBLE_NEW_LINE
				: Constantes.DOUBLE_NEW_LINE + Constantes.UNDERLINE + "[ Arranger les cartes ]" + Constantes.UNDERLINE;
		return action + Constantes.DOUBLE_NEW_LINE + Constantes.NEW_LINE + hand.toString();
	}

	public String getNom() {
		return nom;
	}

}
