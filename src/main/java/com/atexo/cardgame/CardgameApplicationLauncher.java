package com.atexo.cardgame;



/*
 * Ce programme est un exercice de programmation 
 * qui simule un jeu de cartes  avec une main de 10 cartes à mélanger et à trier
 * 
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



/**
 * <p>Cette classe permet de tester les classes Carte, JeuDeCarte.</p>
 * @author Soufiane YOUSFI.
 */
public class CardgameApplicationLauncher {


	/**
	 * <p>Construction de l'application.</p>
	 */
	public CardgameApplicationLauncher()
	{

		// Appel du constructeur de la classe JFrame.
		JFrame fenetre = new JFrame();
		fenetre.setVisible(true);

		// Ajoute les composants au conteneur.
		JTextArea zoneSortie = new JTextArea();
		zoneSortie.setEditable(false);
		fenetre.getContentPane().add(new JScrollPane(zoneSortie), BorderLayout.CENTER);

		// Texte de sortie.
		StringBuilder sortie = new StringBuilder();

		//Joue une partie
		Jeu partie= new Jeu();
		//Resultat de la partie
		String playerName = "Player_1";
		partie.jouer(sortie, playerName);

		// Met � jour la zone de sortie.
		zoneSortie.setText(sortie.toString());

		// Modifie les propri�t�s de la fen�tre.
		fenetre.setSize(1200, 800);
		fenetre.setLocation(200, 100);
		fenetre.setTitle("Jeu De Cartes");
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * <p>D�bute l'ex�cution du test.</p>
	 * @param args Les param�tres de la ligne de commande.
	 */
	public static void main(String[] args)
	{

		new CardgameApplicationLauncher();
	}

}

