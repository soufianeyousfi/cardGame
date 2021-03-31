package com.atexo.cardgame;

/**
 * <p>
 * Cette classe permet de tester une partie d'un joueur.
 * </p>
 * 
 * @author Soufiane YOUSFI.
 */
public class Jeu {

	private JeuDeCarte jeu; // Paquet de 52 cartes

	public Jeu() {

		// Construction du paquet de cartes.
		jeu = new JeuDeCarte();
		jeu.initPaquet();

	}

	/**
	 * Jouer une partie
	 * 
	 * @param sortie
	 *            description de la partie jouer
	 */
	public StringBuilder jouer(StringBuilder sortie, String pName) {

		Joueur player = new Joueur(pName);

		jeu.melanger();
		Carte[] randomCards = jeu.distribuerCartes(10);
		player.ajoute(randomCards);
		sortie.append(player);
		jeu.ordonner(randomCards);
		player.refresh(randomCards);
		sortie.append(player);
		return sortie;

	}

}
