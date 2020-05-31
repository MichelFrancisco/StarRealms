package controller;

import java.util.Scanner;

import view.Visuel;

public class Effects {
	private final String target;
	private final int value;
	private final Effects e2;
	private final Effects e1;

	public Effects(String target, int value) {
		this.target = target;
		this.value = value;
		this.e2 = null;
		this.e1 = null;
	}

	public Effects(String target, int value, String cible) {
		this.target = target;
		this.value = value;
		this.e2 = null;
		this.e1 = null;
	}

	public Effects(String target, Effects e1, Effects e2) {
		this.target = target;
		this.value = 0;
		this.e2 = e2;
		this.e1 = e1;
	}

	// Cherche de quel effet il s'agit et effectue une action en conséquence
	public void applyEffect(Player p,Player badGuy,Shop shop,Deck deckShop) {
		if (target == "combat") p.addCombat(value);
		else if (target == "trade") p.addTrade(value);
		else if (target == "authority") p.addAuthority(value);
		else if (target == "draw") {
			for (int i = 0; i < value; i++) {
				p.drawCard();
			}
		}
		else if(target == "or" && e2 != null) {
			Scanner lectureClavier = new Scanner(System.in);
			int end = 0;
			while(end==0) {
				Visuel.ChoixEffet(e1, e2);
				int rep = lectureClavier.nextInt();
				switch(rep) {
				case 1: e1.applyEffect(p, badGuy, shop, deckShop);
						end = 1;
						break;
				case 2: e2.applyEffect(p, badGuy, shop, deckShop);
						end = 1;
						break;
				default: System.out.println("Valeur choisie invalide");
				}
			}
		}
		else if(target == "and" && e2 != null) {
			e1.applyEffect(p, badGuy, shop, deckShop);
			e2.applyEffect(p, badGuy, shop, deckShop);
		}
		else if(target == "destroyBase") destroyBase(badGuy);
		else if(target == "scrapTrade") scrapTrade(shop, deckShop);
		else if(target == "scrapDeck") scrapDeck(p);
		else if(target == "scrapHand") scrapHand(p, badGuy, shop, deckShop);
		else if(target == "scrapGrave") scrapGrave(p);
	}

	
	
	public void destroyBase(Player badGuy) {
		System.out.println("Voulez vous detruire une base adverse ? [1] Oui [2] Non");
		int end = 0;
		Scanner lectureClavier = new Scanner(System.in);
		while(end==0) {
			int rep = lectureClavier.nextInt();
			switch(rep) {
			case 1:	if(badGuy.getBoard().getBases().size()==0) {
						System.out.println("L'adversaire ne possede pas de base");
					}
					else {
						System.out.printf("Quel base voulez vous detruire (numeroter de 1 a %d)\n",badGuy.getBoard().getBases().size());
						System.out.println(badGuy.getBoard());
						int nb = lectureClavier.nextInt();
						badGuy.getBoard().remove(badGuy.getBoard().get(nb-1));
					}
					end = 1;
					break;
			case 2: end=1;break;
			default: System.out.println("Valeur choisie invalide");
			}
		}
	}


	public void scrapTrade(Shop shop,Deck deckShop) {
		Scanner lectureClavier = new Scanner(System.in);
		int end = 0;
		while(end==0) {
			Visuel.ScrapTrade(shop);
			int rep = lectureClavier.nextInt();
			if (rep > 0 && rep <= shop.size()) {
				shop.remove(rep-1);
				shop.fillShop(deckShop);
				end = 1;
			}
			else System.out.println("Entrez une valeur correcte s'il-vous-plait");
		}
	}
	
	public void scrapDeck(Player p) {
		Scanner lectureClavier = new Scanner(System.in);
		int end = 0;
		while(end==0) {
			Visuel.ScrapDeck(p);
			int rep = lectureClavier.nextInt();
			if (rep > 0 && rep <= p.getDeck().size()) {
				p.getDeck().remove(rep-1);
				end = 1;
			}
			else System.out.println("Entrez une valeur correcte s'il-vous-plait");
		}
	}
	
	public void scrapHand(Player p, Player badGuy, Shop shop, Deck deckShop) {
		Scanner lectureClavier = new Scanner(System.in);
		int end = 0;
		while(end==0) {
			Visuel.ScrapHand(p);
			int rep = lectureClavier.nextInt();
			if (rep > 0 && rep <= p.getHand().size()) {
				 Cards card = p.getHand().remove(rep-1);
				 if (card.getScrapEffect() != null) {
					 card.getScrapEffect().applyEffect(p, badGuy, shop, deckShop);
				 }
				end = 1;
			}
			else System.out.println("Entrez une valeur correcte s'il-vous-plait");
		}
	}
	
	public void scrapGrave(Player p) {
		Scanner lectureClavier = new Scanner(System.in);
		int end = 0;
		while(end==0) {
			Visuel.ScrapGrave(p);
			int rep = lectureClavier.nextInt();
			if (rep > 0 && rep <= p.getGrave().size()) {
				p.getGrave().remove(rep-1);
				end = 1;
			}
			else System.out.println("Entrez une valeur correcte s'il-vous-plait");
		}
	}
	
	public String getTarget() {
		return target;
	}

	public int getValue() {
		return value;
	}
}
