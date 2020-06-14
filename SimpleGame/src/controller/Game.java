package controller;

import java.util.ArrayList;
import java.util.Scanner;

import view.Visuel;

public class Game {



	public void jvjClassic() {



		boolean rejouer = true;
		while (rejouer) {

		// Initialisation des �l�ments de jeu

		Deck deckShop = new Deck();
		Deck deckExplo = new Deck();
		deckExplo.fillExplo();
		Shop shop = new Shop();
		Player p1 = new Player();
		Player p2 = new Player();
		Scanner lectureClavier = new Scanner(System.in);
		p1.initDeck();
		p2.initDeck();

		// Initialisation des cartes de l'extension choisi
		Visuel.extension();
		int extension = lectureClavier.nextInt();
		int ext = 0;
		while (ext == 0) {
			switch(extension) {
			case 1: deckShop.deckExt1(deckShop);ext=1;break;
			case 2: deckShop.deckExtUnited(deckShop);ext=1;break;
			case 3: deckShop.deckExtColony(deckShop);ext=1;break;
			default: System.out.println("Valeur incorrecte");
			}
		}
		deckShop.shufDeck();
		shop.fillShop(deckShop);

		// D�roulement de la partie

		boolean finPose = false;
		

		int tour = 0;
		Player player;
		Player badGuy;

		while (p1.isAlive() && p2.isAlive()) {
			if(tour%2 == 0) {
				player = p1;
				badGuy = p2;
				System.out.println("Tour de p1");
			}
			else {
				player = p2;
				badGuy = p1;
				System.out.println("Tour de p2");
			}

			if(tour == 0) {
				for (int i = 0; i < 3; i++) {
					player.drawCard();
				}
			}
			else {
				for (int i = 0; i < 5; i++) {
					if (player.getDeck().isEmpty()) {
						player.switchDeck();
					}
					player.drawCard();
				}
			}

		// D�roulement d'un tour

		boolean finTour = false;
		while (finTour == false) {
			while(finPose == false) {
				Visuel.statut(player,badGuy);
				Visuel.poser();
				int rep = lectureClavier.nextInt();
				switch(rep) {
					case 1: System.out.println(player.getHand());
							System.out.println("Quelle carte voulez-vous poser ?");
							int nb = lectureClavier.nextInt();
							if (nb > 0 && nb <= player.getHand().size()) {
								player.playCard(nb);

								}
							else {
								System.out.println("Le nombre entr� est invalide");
							}
							break;

					case 2: finPose = true;
							player.getBoard().allEffects(player,badGuy,shop,deckShop, false);
							player.getBoard().allyEffect(player,badGuy,shop,deckShop, false);
							break;

					case 3:
							int len = player.getHand().size();
							for (int i = 0; i != len; i++) {
								player.playCard(1);
							}
							finPose = true;
							player.getBoard().allEffects(player,badGuy,shop,deckShop, false);
							player.getBoard().allyEffect(player,badGuy,shop,deckShop, false);
							break;

					default: System.out.println("Entrez un nombre valide");
				}
			}


		Visuel.menu();

	    int nombre = lectureClavier.nextInt();

		switch(nombre)  {
		case 1: System.out.println(shop);
				Visuel.Explorer();
				System.out.println("Quelle carte voulez-vous acheter ?");
				System.out.print("Vos points de commerces :" + player.getTrade() + "\n");
				int nb2 = lectureClavier.nextInt();
				if(nb2 > 0 && nb2 < 6) {
					shop.buyCard(nb2, player);
					shop.fillShop(deckShop);
					}
				else if(nb2 == 6) {
					player.takeExplo(deckExplo);
					player.addTrade(-2);
					deckExplo.fillExplo();
					}
				else {
					System.out.println("Le nombre entr� est invalide");
				}
				break;

		case 2: System.out.println(player.getBoard());
				System.out.println("Quelle carte voulez-vous d�truire ?");
				int nb3 = lectureClavier.nextInt();
				if (nb3 > 0 && nb3 <= player.getBoard().getLength()) {
					player.getBoard().scrap(nb3,player,badGuy,shop,deckShop, false);
				}
				else {
					System.out.println("Le nombre entr� est invalide");
				}
				break;

		case 3: System.out.println(player.getBoard());
				break;

		case 4:
				if (badGuy.getBoard().getBases().size() != 0) {
					System.out.println("Que voulez vous attaquer ?");
					if (badGuy.getOutpost().size() != 0) {
						System.out.println(badGuy.getOutpost());
						int nb4 = lectureClavier.nextInt();
						if (badGuy.getOutpost().size() >= nb4) {
							String nom = badGuy.getOutpost().get(nb4-1).getName();
							player.atckBase(badGuy.getBoard().findCard(nom), badGuy);
						}
						else {
							System.out.println("Nombre Invalide !");
						}
					break;
					}
					System.out.println("[L'adversaire], " + badGuy.getBoard().getBases());
					int nb4 = lectureClavier.nextInt();
					if (nb4 == 1) {
						System.out.println("Vous infligez " + player.getCombat() + " points de d�gats � l'adversaire");
						badGuy.addAuthority(player.getCombat()*-1);
						player.addCombat(player.getCombat()*-1);
					}
					else {
						if (badGuy.getBoard().getBases().size() >= nb4) {
							String nom = badGuy.getBoard().getBases().get(nb4 - 2).getName();
							player.atckBase(badGuy.getBoard().findCard(nom), badGuy);
							}
							else System.out.println("Nombre Invalide !");
					}
				}
				else {
				System.out.println("Vous infligez " + player.getCombat() + " points de d�gats � l'adversaire");
				badGuy.addAuthority(player.getCombat()*-1);
				player.addCombat(player.getCombat()*-1);
				}
				break;

		case 5: Visuel.statut(player,badGuy);
				break;

		case 6: player.resetPlayer();
				finTour = true;
				finPose = false;
				tour += 1;
				break;

		default:System.out.println("Entrez un chiffre entre 1 et 6");
		}
	   }
	  }
		if (p1.isAlive()) System.out.println("Le joueur 1 est victorieux !");

		else System.out.println("Le joueur 2 est victorieux !");

		boolean reponse = false;
		while (reponse == false) {
		System.out.println("Voulez vous rejouer ?");
		System.out.println("[1] Oui");
		System.out.println("[2] Non");
		int rep = lectureClavier.nextInt();
		switch(rep) {
			case 1: System.out.println("C'est reparti mon kiki !");
					reponse = true;
					break;

			case 2: System.out.println("Ok pas de soucis ! Au revoir mon pote !");
					rejouer = false;
					reponse = true;
					break;

			default: System.out.println("C'est si dur de choisir entre 1 et 2 ?");
		}
		}
	 }
	}

	public void jvIAClassic() {
		boolean rejouer = true;
		while (rejouer) {

		// Initialisation des �l�ments de jeu

		Deck deckShop = new Deck();
		Deck deckExplo = new Deck();
		deckExplo.fillExplo();
		Shop shop = new Shop();
		Player p1 = new Player();
		Player IA = new Player();
		Scanner lectureClavier = new Scanner(System.in);
		p1.initDeck();
		IA.initDeck();

		// Initialisation des cartes de la premiere extension dans le deckShop
		// Initialisation des cartes de l'extension choisi
		Visuel.extension();
		int extension = lectureClavier.nextInt();
		int ext = 0;
		while (ext == 0) {
			switch(extension) {
			case 1: deckShop.deckExt1(deckShop);ext=1;break;
			case 2: deckShop.deckExtUnited(deckShop);ext=1;break;
			case 3: deckShop.deckExtColony(deckShop);ext=1;break;
			default: System.out.println("Valeur incorrecte");
			}
		}
		deckShop.shufDeck();
		shop.fillShop(deckShop);

		// D�roulement de la partie

		boolean finPose = false;
		

		int tour = 0;
		Player player;
		Player badGuy;

		while (p1.isAlive() && IA.isAlive()) {
			if(tour%2 == 0) {
				player = p1;
				badGuy = IA;
				System.out.println("Tour de p1");
			}
			else {
				player = IA;
				badGuy = p1;
				System.out.println("Tour de p2");
			}

			if(tour == 0) {
				for (int i = 0; i < 3; i++) {
					player.drawCard();
				}
			}
			else {
				for (int i = 0; i < 5; i++) {
					if (player.getDeck().isEmpty()) {
						player.switchDeck();
					}
					player.drawCard();
				}
			}

		// D�roulement d'un tour


		boolean finTour = false;

		if (player == IA) {

			// On fait jouer toutes ses cartes � l'IA

			int len = player.getHand().size();
			for (int i = 0; i != len; i++) {
				player.playCard(1);
			}
			finPose = true;
			player.getBoard().allEffects(player,badGuy,shop,deckShop, true);
			player.getBoard().allyEffect(player,badGuy,shop,deckShop, true);

			// On fait acheter ce qu'il peut � l'IA


			for (int i = 1; i < shop.size(); i++) {
				if (IA.getTrade() != 0) {
					if (IA.getTrade() >= shop.get(i).getCost()) {
						System.out.println("L'IA ach�te une carte:");
						System.out.println(shop.get(i));
						shop.buyCard(i, IA);
					}
				}
			}

			// On fait attaquer l'IA

			if (IA.getCombat() != 0) {
				if (p1.getOutpost().size() != 0) {
					for (Base base : p1.getOutpost()) {
						if(IA.getCombat() >= base.getDef()) {
							System.out.printf("L'IA d�truit ",base.getName());
							IA.atckBase(base, IA);
						}
					}
				}

				else {
					System.out.println("L'IA vous attaque et vous inflige " + IA.getCombat() + " points de d�gats");
					p1.addAuthority(IA.getCombat()*-1);
					IA.addCombat(IA.getCombat()*-1);
				}
			}

			// On termine le tour de l'IA
			IA.resetPlayer();
			finPose = false;
			tour += 1;
			continue;
		}

		int countBlob = 0;
		while (finTour == false) {
			while(finPose == false) {
				Visuel.statut(player,badGuy);
				Visuel.poser();
				int rep = lectureClavier.nextInt();
				switch(rep) {
					case 1: System.out.println(player.getHand());
							System.out.println("Quelle carte voulez-vous poser ?");
							int nb = lectureClavier.nextInt();
							if (nb > 0 && nb <= player.getHand().size()) {
								if (player.getHand().get(nb).getFaction() == "Blob") {
									countBlob += 1;
								}
								player.playCard(nb);
								}
							else {
								System.out.println("Le nombre entr� est invalide");
							}
							break;

					case 2: finPose = true;
							player.getBoard().allEffects(player,badGuy,shop,deckShop, false);
							player.getBoard().allyEffect(player,badGuy,shop,deckShop, false);
							break;

					case 3:
							int len = player.getHand().size();
							for (int i = 0; i != len; i++) {
								player.playCard(1);
							}
							finPose = true;
							player.getBoard().allEffects(player,badGuy,shop,deckShop, false);
							player.getBoard().allyEffect(player,badGuy,shop,deckShop, false);
							break;

					default: System.out.println("Entrez un nombre valide");
				}
			}


		Visuel.menu();

	    int nombre = lectureClavier.nextInt();

		switch(nombre)  {
		case 1: System.out.println(shop);
				Visuel.Explorer();
				System.out.println("Quelle carte voulez-vous acheter ?");
				System.out.print("Vos points de commerces :" + player.getTrade() + "\n");
				int nb2 = lectureClavier.nextInt();
				if(nb2 > 0 && nb2 < 6) {
					shop.buyCard(nb2, player);
					shop.fillShop(deckShop);
					}
				else if(nb2 == 6) {
					player.takeExplo(deckExplo);
					player.addTrade(-2);
					deckExplo.fillExplo();
					}
				else {
					System.out.println("Le nombre entr� est invalide");
				}
				break;

		case 2: System.out.println(player.getBoard());
				System.out.println("Quelle carte voulez-vous d�truire ?");
				int nb3 = lectureClavier.nextInt();
				if (nb3 > 0 && nb3 <= player.getBoard().getLength()) {
					player.getBoard().scrap(nb3,player,badGuy,shop,deckShop, false);
				}
				else {
					System.out.println("Le nombre entr� est invalide");
				}
				break;

		case 3: System.out.println(player.getBoard());
				break;

		case 4:
				if (badGuy.getBoard().getBases().size() != 0) {
					System.out.println("Que voulez vous attaquer ?");
					if (badGuy.getOutpost().size() != 0) {
						System.out.println(badGuy.getOutpost());
						int nb4 = lectureClavier.nextInt();
						if (badGuy.getOutpost().size() >= nb4) {
							String nom = badGuy.getOutpost().get(nb4-1).getName();
							player.atckBase(badGuy.getBoard().findCard(nom), badGuy);
						}
						else {
							System.out.println("Nombre Invalide !");
						}
					break;
					}
					System.out.println("[L'adversaire], " + badGuy.getBoard().getBases());
					int nb4 = lectureClavier.nextInt();
					if (nb4 == 1) {
						System.out.println("Vous infligez " + player.getCombat() + " points de d�gats � l'adversaire");
						badGuy.addAuthority(player.getCombat()*-1);
						player.addCombat(player.getCombat()*-1);
					}
					else {
						if (badGuy.getBoard().getBases().size() >= nb4) {
							String nom = badGuy.getBoard().getBases().get(nb4 - 2).getName();
							player.atckBase(badGuy.getBoard().findCard(nom), badGuy);
							}
							else System.out.println("Nombre Invalide !");
					}
				}
				else {
				System.out.println("Vous infligez " + player.getCombat() + " points de d�gats � l'adversaire");
				badGuy.addAuthority(player.getCombat()*-1);
				player.addCombat(player.getCombat()*-1);
				}
				break;

		case 5: Visuel.statut(player,badGuy);
				break;

		case 6: player.resetPlayer();
				finTour = true;
				finPose = false;
				tour += 1;
				break;

		default:System.out.println("Entrez un chiffre entre 1 et 6");
		}
	   }
	  }
		if (p1.isAlive()) System.out.println("Bravo !");

		else System.out.println("L'IA a gagn�");

		boolean reponse = false;
		while (reponse == false) {
		System.out.println("Voulez vous rejouer ?");
		System.out.println("[1] Oui");
		System.out.println("[2] Non");
		int rep = lectureClavier.nextInt();
		switch(rep) {
			case 1: System.out.println("C'est reparti mon kiki !");
					reponse = true;
					break;

			case 2: System.out.println("Ok pas de soucis ! Au revoir mon pote !");
					rejouer = false;
					reponse = true;
					break;

			default: System.out.println("C'est si dur de choisir entre 1 et 2 ?");
		}
		}
	 }
	}

	public void jvjDeathMatch() {

		boolean rejouer = true;
		while (rejouer) {

		// Initialisation des �l�ments de jeu

		Deck deckShop = new Deck();
		Deck deckExplo = new Deck();
		deckExplo.fillExplo();
		Shop shop = new Shop();
		System.out.println("Combien de joueurs ?");
		Scanner lectureClavier = new Scanner(System.in);
		int nbJoueurs = lectureClavier.nextInt();
		ArrayList<Player> listJoueurs = new ArrayList<Player>();
		for (int i = 0; i < nbJoueurs; i++) {
			listJoueurs.add(new Player());
		}
		for (int i = 0; i < nbJoueurs; i++) {
			listJoueurs.get(i).initDeck();
		}

		// Initialisation des cartes de la premiere extension dans le deckShop
		Visuel.extension();
		int extension = lectureClavier.nextInt();
		int ext = 0;
		while (ext == 0) {
			switch(extension) {
			case 1: deckShop.deckExt1(deckShop);ext=1;break;
			case 2: deckShop.deckExtUnited(deckShop);ext=1;break;
			case 3: deckShop.deckExtColony(deckShop);ext=1;break;
			default: System.out.println("Valeur incorrecte");
			}
		}
		deckShop.shufDeck();
		shop.fillShop(deckShop);

		// D�roulement de la partie

		boolean finPose = false;

		int tour = 0;
		Player player;
		Player badGuy = null;
		boolean allAlive = true;

		while (allAlive == true) {
			player = listJoueurs.get(tour);
			System.out.printf("Tour du joueur %d \n", tour + 1);

			if(tour == 0) {
				for (int i = 0; i < 3; i++) {
					player.drawCard();
				}
			}
			else if (tour == 1) {
				for (int i = 0; i < 4; i++) {
					if (player.getDeck().isEmpty()) {
						player.switchDeck();
					}
					player.drawCard();
				}
			}

			else {
				for (int i = 0; i < 5; i++) {
					if (player.getDeck().isEmpty()) {
						player.switchDeck();
					}
					player.drawCard();
				}
			}

		// D�roulement d'un tour

		boolean finTour = false;
		while (finTour == false) {
			while(finPose == false) {
				Visuel.statut(player);
				Visuel.poser();
				int rep = lectureClavier.nextInt();
				switch(rep) {
					case 1: System.out.println(player.getHand());
							System.out.println("Quelle carte voulez-vous poser ?");
							int nb = lectureClavier.nextInt();
							if (nb > 0 && nb <= player.getHand().size()) {
								player.playCard(nb);

								}
							else {
								System.out.println("Le nombre entr� est invalide");
							}
							break;

					case 2: finPose = true;
						boolean truc = false;
						while (truc == false) {
							System.out.println("Quel joueur ciblez vous avec vos effets  ?");
							for (Player Ennemy : listJoueurs) {
								System.out.printf("Joueur %d \n", listJoueurs.indexOf(Ennemy)+1);
								Visuel.statut(Ennemy);
							}
							int cible = lectureClavier.nextInt();
							cible --;
							if (cible == tour) {
								System.out.println("Tu ne peux pas te cibler toi m�me !");
								continue;
							}
							else {
								badGuy = listJoueurs.get(cible);
								truc = true;
							}
						}
							player.getBoard().allEffects(player,badGuy,shop,deckShop, false);
							player.getBoard().allyEffect(player,badGuy,shop,deckShop, false);
							break;

					case 3:
						truc = false;
						while (truc == false) {
							System.out.println("Quel joueur ciblez vous avec vos effets  ?");
							for (Player Ennemy : listJoueurs) {
								System.out.printf("Joueur %d \n", listJoueurs.indexOf(Ennemy)+1);
								Visuel.statut(Ennemy);
							}
							int cible = lectureClavier.nextInt();
							cible --;
							if (cible == tour) {
								System.out.println("Tu ne peux pas te cibler toi m�me !");
								continue;
							}
							else {
								badGuy = listJoueurs.get(cible);
								truc = true;
							}
						}
							int len = player.getHand().size();
							for (int i = 0; i != len; i++) {
								player.playCard(1);
							}
							finPose = true;
							player.getBoard().allEffects(player,badGuy,shop,deckShop, false);
							player.getBoard().allyEffect(player,badGuy,shop,deckShop, false);
							break;

					default: System.out.println("Entrez un nombre valide");
				}
			}


		Visuel.menu();

	    int nombre = lectureClavier.nextInt();

		switch(nombre)  {
		case 1: System.out.println(shop);
				Visuel.Explorer();
				System.out.println("Quelle carte voulez-vous acheter ?");
				System.out.print("Vos points de commerces :" + player.getTrade() + "\n");
				int nb2 = lectureClavier.nextInt();
				if(nb2 > 0 && nb2 < 6) {
					shop.buyCard(nb2, player);
					shop.fillShop(deckShop);
					}
				else if(nb2 == 6) {
					player.takeExplo(deckExplo);
					player.addTrade(-2);
					deckExplo.fillExplo();
					}
				else {
					System.out.println("Le nombre entr� est invalide");
				}
				break;

		case 2: System.out.println(player.getBoard());
				System.out.println("Quelle carte voulez-vous d�truire ?");
				int nb3 = lectureClavier.nextInt();
				if (nb3 > 0 && nb3 <= player.getBoard().getLength()) {
					player.getBoard().scrap(nb3,player,badGuy,shop,deckShop, false);
				}
				else {
					System.out.println("Le nombre entr� est invalide");
				}
				break;

		case 3: System.out.println(player.getBoard());
				break;

		case 4:
			boolean truc = false;
			while (truc == false) {
				System.out.println("Quel joueur voulez vous attaquer  ?");
				for (Player Ennemy : listJoueurs) {
					System.out.printf("Joueur %d \n", listJoueurs.indexOf(Ennemy)+1);
					Visuel.statut(Ennemy);
				}
				int cible = lectureClavier.nextInt();
				cible --;
				if (cible == tour) {
					System.out.println("Tu ne peux pas te cibler toi m�me !");
					continue;
				}
				else {
					badGuy = listJoueurs.get(cible);
					truc = true;
				}
			}
				if (badGuy.getBoard().getBases().size() != 0) {
					System.out.println("Que voulez vous attaquer ?");
					if (badGuy.getOutpost().size() != 0) {
						System.out.println(badGuy.getOutpost());
						int nb4 = lectureClavier.nextInt();
						if (badGuy.getOutpost().size() >= nb4) {
							String nom = badGuy.getOutpost().get(nb4-1).getName();
							player.atckBase(badGuy.getBoard().findCard(nom), badGuy);
						}
						else {
							System.out.println("Nombre Invalide !");
						}
					break;
					}
					System.out.println("[L'adversaire], " + badGuy.getBoard().getBases());
					int nb4 = lectureClavier.nextInt();
					if (nb4 == 1) {
						System.out.println("Vous infligez " + player.getCombat() + " points de d�gats � l'adversaire");
						badGuy.addAuthority(player.getCombat()*-1);
						player.addCombat(player.getCombat()*-1);
					}
					else {
						if (badGuy.getBoard().getBases().size() >= nb4) {
							String nom = badGuy.getBoard().getBases().get(nb4 - 2).getName();
							player.atckBase(badGuy.getBoard().findCard(nom), badGuy);
							}
							else System.out.println("Nombre Invalide !");
					}
				}
				else {
				System.out.println("Vous infligez " + player.getCombat() + " points de d�gats � l'adversaire");
				badGuy.addAuthority(player.getCombat()*-1);
				player.addCombat(player.getCombat()*-1);
				}
				break;

		case 5: Visuel.statut(player);
				for (Player Ennemy : listJoueurs) {
					System.out.printf("Joueur %d \n", listJoueurs.indexOf(Ennemy)+1);
					Visuel.statut(Ennemy);
				}
				break;

		case 6: player.resetPlayer();
				finTour = true;
				finPose = false;
				tour += 1;
				break;

		default:System.out.println("Entrez un chiffre entre 1 et 6");
		}
	   }
		int compte = 0;
		for (Player player2 : listJoueurs) {
			if (player2.isAlive()) {
				compte += 1;
			}
		}
		if (compte == 1) {
			allAlive = false;
			for (Player player2 : listJoueurs) {
				if (player2.isAlive()) {
					String gagnant = "Joueur"+listJoueurs.indexOf(player2);
					System.out.printf("Victoire, le joueur %s a gagn�, Bravo !!! \n", gagnant);
				}
			}
		}
	  }

		boolean reponse = false;
		while (reponse == false) {
		System.out.println("Voulez vous rejouer ?");
		System.out.println("[1] Oui");
		System.out.println("[2] Non");
		int rep = lectureClavier.nextInt();
		switch(rep) {
			case 1: System.out.println("C'est reparti mon kiki !");
					reponse = true;
					break;

			case 2: System.out.println("Ok pas de soucis ! Au revoir mon pote !");
					rejouer = false;
					reponse = true;
					break;

			default: System.out.println("C'est si dur de choisir entre 1 et 2 ?");
		}
		}
	 }
	}

}
