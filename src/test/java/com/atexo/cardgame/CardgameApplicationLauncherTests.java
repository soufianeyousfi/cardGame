package com.atexo.cardgame;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CardgameApplicationLauncherTests {

	@Test
	void contextLoads() {

	}

	// nouvelle partie
	JeuDeCarte jeu = new JeuDeCarte();

	@Test
	public void tester() {
		// Paquet vide
		Assertions.assertTrue(jeu.getNb_Carte() == BigDecimal.ZERO.intValue());

		// Paquet de 52 cartes
		jeu.initPaquet();
		Assertions.assertTrue(jeu.getNb_Carte() == 52);
		// main de 10 cartes
		Carte[] cards = jeu.distribuerCartes(10);
		Assertions.assertTrue(cards.length == 10);
		// Melanger les cartes
		Carte[] shuffledCards = jeu.melanger();
		Assertions.assertTrue(!shuffledCards.equals(cards));

	}

	@Test
	public void testerTriCartes() {
		Carte c1 = new Carte("2", Couleur.Pique.name(), 0);
		Carte c2 = new Carte("4", Couleur.Pique.name(), 2);
		Carte c3 = new Carte("3", Couleur.Pique.name(), 1);

		Carte[] cards = { c1, c3, c2 };
		jeu.ajoute(c3);
		jeu.ajoute(c1);
		jeu.ajouteALaFin(c2);
		jeu.ordonner(cards);
		Assertions.assertTrue(cards[0].estEgal(c1));
		Assertions.assertTrue(cards[1].estEgal(c3));
		Assertions.assertTrue(cards[2].estEgal(c2));
		Assertions.assertTrue(jeu.getNb_Carte() == cards.length);

	}

	@Test
	public void testerTriCouleurMixte() {
		Carte c1 = new Carte("2", Couleur.Pique.name(), 0);
		Carte c4 = new Carte("2", Couleur.Carreau.name(), 0);
		Carte c2 = new Carte("4", Couleur.Pique.name(), 2);
		Carte c6 = new Carte("3", Couleur.Carreau.name(), 1);
		Carte c3 = new Carte("3", Couleur.Pique.name(), 1);
		Carte c5 = new Carte("4", Couleur.Carreau.name(), 2);
		Carte[] cards = { c1, c5, c2, c4, c6, c3 };
		jeu.ajoute(c3);
		jeu.ajoute(c1);
		jeu.ajoute(c2);
		jeu.ajoute(c4);
		jeu.ajoute(c5);
		jeu.ajouteALaFin(c6);

		System.out.println(cards.length);
		System.out.println(jeu.getNb_Carte());
		// Pr�senter la main tri�e
		jeu.ordonner(cards);
		Assertions.assertTrue(cards[0].estEgal(c1));
		Assertions.assertTrue(cards[1].estEgal(c3));
		Assertions.assertTrue(cards[2].estEgal(c2));
		Assertions.assertTrue(cards[3].estEgal(c4));
		Assertions.assertTrue(cards[4].estEgal(c6));
		Assertions.assertTrue(cards[5].estEgal(c5));
		Assertions.assertTrue(jeu.getNb_Carte() == cards.length);

	}
}
