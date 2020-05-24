package controller;

import java.util.ArrayList;
import java.util.Collections;

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
		Base b1 = new Base(3,"Blob Wheel","Blob",5, new Effects("combat", 1), new Effects("trade", 3) ,true);
		
		Ships s4 = new Ships(2,"Corvette","Star Empire", new Effects("combat", 1), null,new Effects("draw", 1),new Effects("combat",2));
		Ships s5 = new Ships(7,"Dreadnaught","Star Empire", new Effects("combat", 7), new Effects("draw", 1), new Effects("combat", 5));
		Base b2 = new Base(4,"Space Station","Star Empire",4, new Effects("combat", 2),null, new Effects("trade", 4),new Effects("combat",2) ,true);
		Base b3 = new Base(5,"War World","Star Empire",4,new Effects("combat",3), null, null, new Effects("combat",4),true);
		
		Ships s9 = new Ships(6,"Flagship","Trade Federation",new Effects("combat",5),new Effects("draw",1),null, new Effects("authority",5));
		Ships s8 = new Ships(1,"Federation Shuttle","Trade Federation",new Effects("trade",2),null,null,new Effects("authority",4));
		Ships s7 = new Ships(3,"Embassy Yacht","Trade Federation",new Effects("trade",2),new Effects("authority",3));
		Ships s6 = new Ships(2,"Cutter","Trade Federation", new Effects("trade",2),new Effects("authority",4),null, new Effects("combat",4));
		Base b4 = new Base(4,"Barter World", "Trade Federation",4, new Effects("or", new Effects("authority",2), new Effects("trade",2)), null, null, new Effects("combat",5),false);
		Base b5 = new Base(5, "Defense Center", "Trade Federation", 5, new Effects("or", new Effects("authority",3), new Effects("combat",2)), null, new Effects("combat",2), null, true);
		Base b6 = new Base(3, "Trading Post", "Trade Federation", 4, new Effects("or", new Effects("authority",1), new Effects("trade",1)), null, null, new Effects("combat",2), true);
		
		deckShop.addCard(s9);
		deckShop.addCard(b3);
		deckShop.addCard(s5);
		deckShop.addCard(s1);
		deckShop.addCard(b5);
		
		for (int i = 0; i < 2; i++) {
			deckShop.addCard(b2);
			deckShop.addCard(s7);
			deckShop.addCard(s4);
			deckShop.addCard(s2);
			deckShop.addCard(b4);
			deckShop.addCard(b6);
		}
		
		for (int i = 0; i < 3; i++) {
			deckShop.addCard(b1);
			deckShop.addCard(s8);
			deckShop.addCard(s6);
			deckShop.addCard(s3);
		}
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
		for (Cards cards : deck) {
			System.out.println(cards);
		}
	}
	
	@Override
	public String toString() {
		return deck.toString();
	}
	
	
}
