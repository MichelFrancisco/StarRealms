package controller;

import java.util.ArrayList;
import java.util.Collections;

import controller.united.Mission;

public class Deck {
	private ArrayList<Cards> deck = new ArrayList<Cards>();
	
	public Deck() {
		deck = new ArrayList<>();
	}
	// Permet d'ajouter une carte au deck
	public void addCard(Cards card) {
		deck.add(card);
	}
	
	// Permet de retirer une carte du deck
	public Cards remove(int x) {
		return deck.remove(x);
	}
	
	// Vérifie si le deck est vide
	public boolean isEmpty() {
		return deck.isEmpty();
	}
	
	public void deckExt1(Deck deckShop) {
		Ships s1 = new Ships(6,"Battle Blob","Blob", new Effects("combat", 8),null, new Effects("combat", 4), new Effects("draw",1));
		Ships s2 = new Ships(3,"Ram","Blob", new Effects("combat", 5),null, new Effects("trade", 3),new Effects("combat",2));
		Ships s3 = new Ships(2,"Trade Pod","Blob", new Effects("trade", 3), null,null,new Effects("combat",2));
		Ships s10 = new Ships(1,"Blob Fighter","Blob",new Effects("combat",3),null,null,new Effects("draw",1));
		Ships s11 = new Ships(7,"Mothership","Blob",new Effects("combat",6),new Effects("draw",1),null,new Effects("draw",1));
		Ships s20 = new Ships(7,"Blob Destroyer","Blob",new Effects("combat",6),new Effects("or",new Effects("or",new Effects("destroyBase",1),new Effects("scrapTrade",1)),new Effects("and",new Effects("destroyBase",1),new Effects("scrapTrade",1))),null);
		
		Base b1 = new Base(3,"Blob Wheel","Blob",5, new Effects("combat", 1), new Effects("trade", 3) ,true);
		Base b7 = new Base(5,"The Hive","Blob",5, new Effects("combat", 3),null,null,new Effects("draw",1) ,false);

		
		Ships s4 = new Ships(2,"Corvette","Star Empire", new Effects("combat", 1), null,new Effects("draw", 1),new Effects("combat",2));
		Ships s5 = new Ships(7,"Dreadnaught","Star Empire", new Effects("combat", 7), new Effects("draw", 1), new Effects("combat", 5));
		Base b2 = new Base(4,"Space Station","Star Empire",4, new Effects("combat", 2),null, new Effects("trade", 4),new Effects("combat",2) ,true);
		Base b3 = new Base(5,"War World","Star Empire",4,new Effects("combat",3), null, null, new Effects("combat",4),true);
		
		Ships s9 = new Ships(6,"Flagship","Trade Federation",new Effects("combat",5),new Effects("draw",1),null, new Effects("authority",5));
		Ships s8 = new Ships(1,"Federation Shuttle","Trade Federation",new Effects("trade",2),null,null,new Effects("authority",4));
		Ships s7 = new Ships(3,"Embassy Yacht","Trade Federation",new Effects("trade",2),new Effects("authority",3));
		Ships s6 = new Ships(2,"Cutter","Trade Federation", new Effects("trade",2),new Effects("authority",4),null, new Effects("combat",4));
		Ships s12 = new Ships(5,"Trade Escort","Trade Federation",new Effects("authority",4),new Effects("combat",4),null,new Effects("draw",1));
		Ships s13 = new Ships(8,"Command Ship","Trade Federation",new Effects("authority",4),new Effects("and",new Effects("combat",5),new Effects("draw",2)),null,new Effects("destroyBase",1));
		Base b4 = new Base(4,"Barter World", "Trade Federation",4, new Effects("or", new Effects("authority",2), new Effects("trade",2)), null, null, new Effects("combat",5),false);
		Base b5 = new Base(5, "Defense Center", "Trade Federation", 5, new Effects("or", new Effects("authority",3), new Effects("combat",2)), null, new Effects("combat",2), null, true);
		Base b6 = new Base(3, "Trading Post", "Trade Federation", 4, new Effects("or", new Effects("authority",1), new Effects("trade",1)), null, null, new Effects("combat",2), true);
		Base b11 = new Base(6,"Port of Call","Trade Federation",6,new Effects("trade",3),null,new Effects("and",new Effects("draw",1),new Effects("destroyBase",1)),null,true);
		
		Ships s14 = new Ships(1,"Trade Bot","Machine Cult",new Effects("trade",1),new Effects("or",new Effects("scrapHand",1),new Effects("scrapGrave",1)),null,new Effects("combat",2));
		Ships s15 = new Ships(3,"Supply Bot","Machine Cult",new Effects("trade",2),new Effects("or",new Effects("scrapHand",1),new Effects("scrapGrave",1)),null,new Effects("combat",2));
		Ships s16 = new Ships(4,"Patrol Mech","Machine Cult",new Effects("or",new Effects("trade",3),new Effects("combat",5)),null,null,new Effects("or",new Effects("scrapHand",1),new Effects("scrapGrave",2)));
		Ships s17 = new Ships(6,"Missile Mech","Machine Cult",new Effects("combat",6),new Effects("destroyBase",1),null,new Effects("draw",1));
		Ships s18 = new Ships(2,"Missile Bot","Machine Cult",new Effects("combat",2),new Effects("or",new Effects("scrapHand",1),new Effects("scrapGrave",1)),null,new Effects("combat",2));
		Ships s19 = new Ships(5,"Battle Mech","Machine Cult",new Effects("combat",4),new Effects("or",new Effects("scrapHand",1),new Effects("scrapGrave",1)),null,new Effects("draw",1));
		Base b8 = new Base(3,"Battle Station","Machine Cult",5,null,null,new Effects("combat",5),null,true);
		Base b9 = new Base(7,"Machine Base","Machine Cult",6,new Effects("draw",1),new Effects("scrapHand",1),null,null,true);
		Base b10 = new Base(6,"Junkyard","Machine Cult",5,new Effects("or",new Effects("scrapHand",1),new Effects("scrapGrave",2)),null,null,null,true);
		
		deckShop.addCard(s9);
		deckShop.addCard(b3);
		deckShop.addCard(s5);
		deckShop.addCard(s1);
		deckShop.addCard(b5);
		deckShop.addCard(s11);
		deckShop.addCard(b7);
		deckShop.addCard(s17);
		deckShop.addCard(s19);
		deckShop.addCard(b9);
		deckShop.addCard(b10);
		deckShop.addCard(s12);
		deckShop.addCard(s13);
		deckShop.addCard(b11);	
		
		for (int i = 0; i < 2; i++) {
			deckShop.addCard(b2);
			deckShop.addCard(s7);
			deckShop.addCard(s4);
			deckShop.addCard(s2);
			deckShop.addCard(b4);
			deckShop.addCard(b6);
			deckShop.addCard(s20);
			deckShop.addCard(s16);
			deckShop.addCard(b8);
		}
		
		for (int i = 0; i < 3; i++) {
			deckShop.addCard(b1);
			deckShop.addCard(s8);
			deckShop.addCard(s6);
			deckShop.addCard(s3);
			deckShop.addCard(s10);
			deckShop.addCard(s14);
			deckShop.addCard(s15);
			deckShop.addCard(s18);
		}
	}
	
	public void addMission(Deck missionDeck) {
		Mission m1 = new Mission("Ally","Use Ally abilities from two different factions in the same turn", "Acquire a ship or base of cost four or less for free and put it on top of your deck");
		Mission m2 = new Mission("Armada","Play seven or more ships in the same turn", "Draw a card. Acquire an explorer for free and put it in your hand");
		Mission m3 = new Mission("Colonize","Have two or more bases of the same faction in play", "Draw two cards");
		Mission m4 = new Mission("Convert","Play a Machine Cult ship while you have a Machine Cult base in play", "Reveal the top three cards of your deck. Put one in your hand, one in you discard pile, and one on top of your deck");
		Mission m5 = new Mission("Defend","Have two or more outposts in play", "Draw a card. Return target base to it's controller's hand");
		Mission m6 = new Mission("Diversify","In a single turn, gain: 4 Trade and 5 Combat and 3 Authority", "Add 4 Trade or 5 Combat or 6 Authority");
		Mission m7 = new Mission("Dominate","Play a Star Empire ship while you have a Star Empire base in play", "Add 3 Combat. Draw a card");
		Mission m8 = new Mission("Exterminate","Play a Blob ship while you have a Blob base in play", "Add 3 Combat. Scrap any number of cards currently in the trade row");
		Mission m9 = new Mission("Influence","Have at least three ships and/or bases of the same faction in play", "Acquire two explorers for free and put them both into your hand");
		Mission m10 = new Mission("Monopolize","Play a Trade Federation ship while you have a Trade Federation base in play", "Add 10 Authority");
		Mission m11 = new Mission("Rule","Have bases from two or more factions in play", "Acquire a card of cost three or less for free and put it in your hand");
		Mission m12 = new Mission("Unite","Play three ships from different factions in the same turn", "Add 5 Authority. Draw a card");
		
		missionDeck.addCard(m1);
		missionDeck.addCard(m2);
		missionDeck.addCard(m3);
		missionDeck.addCard(m4);
		missionDeck.addCard(m5);
		missionDeck.addCard(m6);
		missionDeck.addCard(m7);
		missionDeck.addCard(m8);
		missionDeck.addCard(m9);
		missionDeck.addCard(m10);
		missionDeck.addCard(m11);
		missionDeck.addCard(m12);
		
	}
	
	// Mélange le deck
	public void shufDeck() {
		Collections.shuffle(deck);
	}
	
	//Rempli le deck avec 10 explorateurs (Pour la pile d'explorateur)
	public void fillExplo() {
		while(deck.size()<10) {
			deck.add(new Ships(2,"Explorer","Unaligned", new Effects("trade", 2),null, null, new Effects("combat",2)));
		}
	}
	
	public int size() {
		return deck.size();
	}
	
	public void printDeck() {
		int compte = 1;
		for (Cards cards : deck) {
			System.out.println(compte);
			System.out.println(cards);
			compte += 1;
		}
	}
	
	@Override
	public String toString() {
		return deck.toString();
	}
	
	
}
