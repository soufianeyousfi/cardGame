package com.atexo.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Cette classe modélise un jeu de 52 cartes.
 * </p>
 * 
 * @author Soufiane YOUSFI.
 */
public class JeuDeCarte {

	/** Le paquet de cartes. */
	private Carte[] paquet;

	/** Le nombre de cartes contenues dans le tableau */
	private int nb_Carte;
	/**
	 * Hauteur des cartes du paquet: 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame,
	 * Roi, As.
	 */
	private String[] valeurs = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As" };

	/**
	 * Constructeur du Jeu De Carte vide . Creation d'un paquet de 52 cartes
	 * maximum vide au départ
	 */
	public JeuDeCarte() {
		paquet = new Carte[Couleur.values().length * valeurs.length];
		nb_Carte = 0;
	}

	/**
	 * Permet de connaitre combien de carte contient le paquet
	 * 
	 * @return le nombre de carte que contient le paquet
	 */
	public int getNb_Carte() {
		return nb_Carte;
	}

	/**
	 * Remplissage d'un jeu complet de 52 cartes. Cette fonction initialise le
	 * paquet de maniere a avoir un jeu complet des cartes sans repetition et
	 * ordonne.
	 */
	public void initPaquet() {
		String[] couleurs = Couleur.getNames(Couleur.class);
		// Initialisation des cartes du paquet.
		int couleurSize = getSize(Couleur.values());
		int valeursSize = getSize(valeurs);
		nb_Carte = couleurSize * valeursSize;
		for (int i = 0; i < couleurSize; i++) {
			for (int j = 0; j < valeursSize; j++) {
				paquet[i * valeursSize + j] = new Carte(valeurs[j], couleurs[i], j + 1);
			}
		}
	}

	private int getSize(Object[] pValue) {

		return pValue.length;
	}

	public Carte[] distribuerCartes(int pValue) {
		return Arrays.copyOfRange(paquet, 0, pValue);
	}

	/**
	 * Mélange le paquet . On echange de maniere aleatoire les cartes du paquet
	 */
	public Carte[] melanger() {
		List<Carte> ls = new ArrayList<Carte>(0);

		Carte temp;
		int i, j = 0, k = 0;
		// for ( i =0; i <500; i++){
		for (i = 0; i < paquet.length; i++) {
			j = (int) (Math.random() * nb_Carte);
			k = (int) (Math.random() * nb_Carte);

			temp = paquet[j];
			ls.add(temp);
			paquet[j] = paquet[k];
			paquet[k] = temp;
		}
		return paquet;
	}

	/**
	 * Ajoute une carte au début du paquet .
	 * 
	 * @param c
	 *            La carte a ajouter
	 * @return vrai si la carte a ete ajoutee correctement, faux dans le cas
	 *         contraire ( paquet plein )
	 */
	public boolean ajoute(Carte c) {
		if (nb_Carte < 51) {
			paquet[nb_Carte] = c;
			nb_Carte++;
			return true;
		} else
			return false;
	}

	public void refresh(Carte[] c) {
		paquet = c;
	}

	/**
	 * Ajoute une carte a la fin du paquet .
	 * 
	 * @param c
	 *            La carte a ajouter
	 * @return vrai si la carte a ete ajoutee correctement, faux dans le cas
	 *         contraire ( paquet plein )
	 */
	public boolean ajouteALaFin(Carte c) {

		if (nb_Carte < 51) {
			nb_Carte++;
			for (int j = nb_Carte; j > 0; j--)
				paquet[j] = paquet[j - 1];
			paquet[0] = c;
			return true;
		}

		else
			return false;

	}

	/**
	 * Construit une chaine de caracteres qui represente le paquet de 52 cartes
	 * .
	 * 
	 * @return la representation texte du paquet de 52 cartes.
	 */
	public String toString() {
		String affichage = "";

		if (nb_Carte == 0) {
			return Constantes.TABULATION + "Paquet Vide ! ";
		}

		for (int i = 0; i < nb_Carte; i++) {
			affichage = affichage + paquet[i] + Constantes.NEW_LINE;
		}

		return affichage;
	}

	public void ordonner(Carte[] pCartes) {
		Arrays.sort(pCartes);

	}

}
